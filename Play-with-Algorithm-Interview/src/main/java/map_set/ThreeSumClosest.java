package map_set;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    /**
     * 排序 + 指针对撞
     * 时间复杂度: O(n^2)
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // 排序 nlogn
        int res = nums[0] + nums[1] + nums[2];  // 存放结果

        // 遍历过程中把 i 放在最小的位置上，然后使用 l、r 指针对撞考察 i 右边的元素，
        // 考察 (i,l,r) 三元组的和，看和 target 的接近程度
        for (int i = 0; i < nums.length - 2; i++) {
            int equalNum = target - nums[i];  // 寻找双指针最接近 equalNum 的情况
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                res = getClosest(target, res, nums[i] + nums[l] + nums[r]);
                if (nums[l] + nums[r] == equalNum) {
                    return target;  // 此时三元组的和正好等于 target
                } else if (nums[l] + nums[r] > equalNum) {
                    r--;  // 两数和大于 equal，右边界左移
                } else {
                    l++;  // 两数和小于 equal，左边界右移
                }
            }
        }

        return res;
    }

    // 辅助函数，返回 num1 和 num2 中更接近 target 的一个
    private int getClosest(int target, int num1, int num2) {
        int deltaNum1 = Math.abs(target - num1);
        int deltaNum2 = Math.abs(target - num2);
        return deltaNum1 < deltaNum2 ? num1 : num2;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();

        int[] nums1 = {-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(nums1, 1));   // 2
    }
}
