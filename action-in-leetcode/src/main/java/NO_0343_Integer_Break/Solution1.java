package NO_0343_Integer_Break;

/**
 * 0343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 * <p>
 * 暴力递归
 * 时间复杂度: O(n^n)
 * 空间复杂度: O(n)
 */
class Solution1 {
    public int integerBreak(int n) {
        if (n == 1) return 1;
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * integerBreak(n - i));
        }
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}