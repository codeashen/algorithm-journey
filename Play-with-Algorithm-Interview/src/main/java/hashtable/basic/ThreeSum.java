package hashtable.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    /**
     * 排序 + 双指针
     * 时间复杂度 O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);  // O(nlogn)

        // 遍历过程中把 i 放在最小的位置上，然后使用 l、r 指针对撞考察 i 右边的元素，
        // 得到解后按照 (i,l,r) 的顺序返回，自然是从大到小的，期间进行跳过重复元素操作
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;  // 如果最小的 i 都大于 0，后面都大于 0
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // 跳过重复的 i
            int target = -nums[i];  // 对撞指针需要满足的条件
            int l = i + 1, r = nums.length - 1;  // 定义双指针
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;  // 跳过重复的 l
                    while (l < r && nums[r] == nums[r + 1]) r--;  // 跳过重复的 r
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {  // nums[l] + nums[r] > target
                    l++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1));   // [[-1,-1,2], [-1,0,1]]
    }
}
