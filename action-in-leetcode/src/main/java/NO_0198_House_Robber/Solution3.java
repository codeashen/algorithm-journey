package NO_0198_House_Robber;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 动态规划
 */
@Complexity(time = "n", space = "n")
class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[n + 1];  // memo[i] 表示窃取前 i 个房子获得的最大收益
        memo[0] = 0;        // 前 0 个，一个不偷，收益 0 
        memo[1] = nums[0];  // 前 1 个，最大收益就是 nums[0]
        for (int i = 2; i <= n; i++) {
            memo[i] = Math.max(memo[i - 1], nums[i - 1] + memo[i - 2]);
        }
        return memo[n];
    }
}