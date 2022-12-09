package NO_0198_House_Robber;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.Arrays;

/**
 * 0198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 记忆化搜索
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    // memo[i] 表示窃取前 i 个房子获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;        // 前 0 个，一个不偷，收益 0 
        memo[1] = nums[0];  // 前 1 个，最大收益就是 nums[0]
        return rob(nums, nums.length);
    }

    // 计算窃取 nums 中前 i 个房子获取的最大收益
    private int rob(int[] nums, int i) {
        if (memo[i] != -1) return memo[i];
        int res = Math.max(rob(nums, i - 1), nums[i - 1] + rob(nums, i - 2));
        memo[i] = res;
        return res;
    }
}