package dynamic_programming.integer_break;

/**
 * 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/description/
 * <p>
 * 暴力求解
 * 时间复杂度: O(n^n)
 * 空间复杂度: O(n)
 */
public class IntegerBreak1 {

    /**
     * 暴力递归求解
     */
    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }

        // 记录最大乘积
        int res = -1;
        // 这个循环表示每次都能将 n 分割成 i + (n-1) 的形式
        for (int i = 1; i <= n - 1; i++) {
            // 这里需要对比三个数
            // (1) 当前的 res
            // (2) 只分割成两个数  i * (n-i)
            // (3) 分割三个及以上  i * integerBreak(n-i) 
            res = max3(res, i * (n - i), i * integerBreak(n - i));
        }
        return res;
    }

    /**
     * 辅助方法，求三个数的最大值
     */
    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    public static void main(String[] args) {
        System.out.println(new IntegerBreak1().integerBreak(2));   // 1
        System.out.println(new IntegerBreak1().integerBreak(58));  // 超时（1549681956）
    }
}
