package dynamic_programming.integer_break;

import java.util.Arrays;

/**
 * 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/description/
 * <p>
 * 记忆化搜索
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
public class IntegerBreak2 {

    // 存储子结果
    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return integerBreakMemo(n);
    }

    /**
     * 记忆化搜索求解
     */
    public int integerBreakMemo(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        // 记录最大乘积
        int res = -1;
        // 这个循环表示每次都能将 n 分割成 i + (n-1) 的形式
        for (int i = 1; i <= n - 1; i++) {
            // 这里需要对比三个数
            // (1) 当前的 res
            // (2) 只分割成两个数  i * (n-i)
            // (3) 分割三个及以上  i * integerBreak(n-i) 
            res = max3(res, i * (n - i), i * integerBreakMemo(n - i));
        }
        memo[n] = res;
        return res;
    }

    /**
     * 辅助方法，求三个数的最大值
     */
    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    public static void main(String[] args) {
        System.out.println(new IntegerBreak2().integerBreak(2));   // 1
        System.out.println(new IntegerBreak2().integerBreak(58));  // 1549681956
    }
}
