package NO_0416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

/**
 * 0416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * <p>
 * 暴力递归
 */
class Solution1 {
    public boolean canPartition(int[] nums) {
        // 计算 nums 总和，如果总和为奇数，肯定不能分割出等和子集
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        // 如果能从 nums 中找到总和为 sum/2 的子集，则满足题目要求
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    /**
     * 尝试从 nums[0, idx] 中取出一个子集，使得组合总和为 sum，
     * 返回是否存在这样的组合
     */
    private boolean tryPartition(int[] nums, int idx, int sum) {
        if (idx < 0 || sum < 0) return false;
        if (sum == 0) return true;
        // ① nums[idx] 不放入，从 nums[0, idx-1] 中找出和为 sum 的子集
        // ② nums[idx] 放入，从 nums[0, idx-1] 中找出和为 sum-nums[idx] 的子集
        return tryPartition(nums, idx - 1, sum)
                || tryPartition(nums, idx - 1, sum - nums[idx]);
    }
}