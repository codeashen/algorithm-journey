package NO_0070_Climbing_Stairs;

/**
 * 0070. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 记忆化搜索
 */
class Solution2 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return calcWays(n, memo);
    }

    private int calcWays(int n, int[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] == 0) {
            memo[n] = calcWays(n - 1, memo) + calcWays(n - 2, memo);
        }
        return memo[n];
    }
}