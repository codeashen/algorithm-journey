package NO_0198_House_Robber;

/**
 * 0198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 暴力递归（超时）
 */
class Solution1 {
    public int rob(int[] nums) {
        return rob(nums, nums.length);
    }

    // 计算窃取 nums 中前 i 个房子获取的最大收益
    private int rob(int[] nums, int i) {
        if (i == 0) return 0;
        if (i == 1) return nums[0];
        return Math.max(rob(nums, i - 1), nums[i - 1] + rob(nums, i - 2));
    }
}