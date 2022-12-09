package dynamic_programming.integer_break;

/**
 * 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/description/
 * <p>
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
public class IntegerBreak3 {

    public int integerBreak(int n) {
        // 存储子结果
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {  // 循环求解 meme[i]
            for (int j = 1; j <= i - 1; j++) {  // 对 i 有 j=i-1 种分割方式
                // 这里需要对比三个数
                // (1) 当前的 memo[i]
                // (2) 只分割成两个数  j * (i-j)
                // (3) 分割三个及以上  j * integerBreak(i-j) 
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    /**
     * 辅助方法，求三个数的最大值
     */
    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    public static void main(String[] args) {
        System.out.println(new IntegerBreak3().integerBreak(2));   // 1
        System.out.println(new IntegerBreak3().integerBreak(58));  // 1549681956
    }
}
