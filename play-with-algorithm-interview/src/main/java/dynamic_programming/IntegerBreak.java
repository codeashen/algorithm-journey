package dynamic_programming;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为 `至少` 两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }

        // 记录最大乘积
        int res = -1;
        // 这个循环表示每次都能将 n 分割成 i + (n-1) 的形式
        for (int i = 1; i <= n - 1; i++) {
            // 比较结果，注意这里要比较三个，要加上之分割两个的情况 i*(n-1)
            res = max3(res, i * (n - i), i * integerBreak(n - i));
        }
        return res;
    }

    // 辅助方法，求三个数的最大值
    private static int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(58));
    }

}
