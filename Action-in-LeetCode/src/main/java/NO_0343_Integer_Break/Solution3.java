package NO_0343_Integer_Break;

/**
 * 0343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 * <p>
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
class Solution3 {
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n - 1; j++) {
                memo[i] = max3(memo[i], j * (n - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}