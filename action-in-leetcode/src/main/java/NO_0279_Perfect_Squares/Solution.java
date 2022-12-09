package NO_0279_Perfect_Squares;

/**
 * 0279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 * <p>
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, 1 + f[n - j * j]);
            }
            f[i] = min;
        }
        return f[n];
    }
}