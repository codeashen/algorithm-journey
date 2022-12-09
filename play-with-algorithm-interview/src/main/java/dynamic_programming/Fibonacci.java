package dynamic_programming;

import java.util.Arrays;

/**
 * 求斐波那契数列第 n 项
 * 1 1 2 3 5 8...
 */
public class Fibonacci {

    // region 递归
    public static int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }
    // endregion 递归

    // region 记忆化搜索
    public static int fib2(int n) {
        // 使用数组记录递归结果
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return memoryFib(n, memo);
    }
    
    private static int memoryFib(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 优先取数组中的结果，没有才进行递归
        if (memo[n] == -1) {
            memo[n] = memoryFib(n - 1, memo) + memoryFib(n - 2, memo);
        }
        return memo[n];
    }
    // endregion 记忆化搜索

    // region 动态规划
    public static int fib3(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
    // endregion 动态规划

    public static void main(String[] args) {
        System.out.println(fib1(20));
        System.out.println(fib2(20));
        System.out.println(fib3(20));
    }
}
