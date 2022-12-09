package NO_10_I;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.Arrays;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * <p>
 * 记忆化搜索
 */
@Complexity(time = "N", space = "N")
class Solution1 {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib(n, memo);
    }

    private int fib(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] == -1) {
            memo[n] = (fib(n - 1, memo) + fib(n - 2, memo)) % 1000000007;
        }
        return memo[n];
    }
}
