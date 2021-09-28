package NO_0016_3Sum_Closest;

import java.util.Arrays;

/**
 * 0016. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 * <p>
 * 排序 + 指针对撞
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(logN)
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // 排序 nlogn
        int res = nums[0] + nums[1] + nums[2];  // 存放结果

        // 遍历过程中把 i 放在最小的位置上，然后使用 l、r 指针对撞考察 i 右边的元素，
        // 考察 (i,l,r) 三元组的和，看和 target 的接近程度
        for (int i = 0; i < nums.length - 2; i++) {
            int towSum = target - nums[i];      // 寻找双指针最接近 towSum 的情况
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                res = getClosest(target, res, nums[i] + nums[l] + nums[r]);
                // 注意这里不能只用 res 和 target 来比较大小，因为 res 可能是原来的 res 不一定是本次三元组的和
                if (nums[l] + nums[r] == towSum) 
                    return target;
                else if (nums[l] + nums[r] < towSum) 
                    l++;
                else 
                    r--;
            }
        }

        return res;
    }

    // 辅助函数，返回 num1 和 num2 中更接近 target 的一个
    private int getClosest(int target, int num1, int num2) {
        int delta1 = Math.abs(target - num1);
        int delta2 = Math.abs(target - num2);
        return delta1 < delta2 ? num1 : num2;
    }
}
