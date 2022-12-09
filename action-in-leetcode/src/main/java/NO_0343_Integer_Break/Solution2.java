package NO_0343_Integer_Break;

import java.util.Arrays;

/**
 * 0343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 * <p>
 * 记忆化搜索
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
class Solution2 {
    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        memo[1] = 1;
        Arrays.fill(memo, -1);
        integerBreakMemo(n);
        return memo[n];
    }
    
    public int integerBreakMemo(int n) {
        if (memo[n] != -1) return memo[n];
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * integerBreakMemo(n - i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}