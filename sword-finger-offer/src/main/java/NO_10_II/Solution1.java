package NO_10_II;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.Arrays;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>
 * 记忆化搜索
 */
@Complexity(time = "N", space = "N")
class Solution1 {
    public int numWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calc(n, memo);
    }

    private int calc(int n, int[] memo) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        if (memo[n] == -1) {
            memo[n] = (calc(n - 1, memo) + calc(n - 2, memo)) % 1000000007;
        }
        return memo[n];
    }
}
