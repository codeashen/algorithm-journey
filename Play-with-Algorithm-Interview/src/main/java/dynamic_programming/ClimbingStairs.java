package dynamic_programming;

import java.util.Arrays;

/**
 * 70. 爬台阶
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbingStairs {

    // region 递归
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }
    // endregion 递归

    // region 记忆化搜索
    public static int climbStairs2(int n) {
        // 初始化数组
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calcWays(n, memo);
    }

    // 记忆化搜索方法
    private static int calcWays(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] == -1) {
            memo[n] = calcWays(n - 1, memo) + calcWays(n - 2, memo);
        }
        return memo[n];
    }
    // endregion 记忆化搜索

    // region 动态规划
    public static int climbStairs3(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
    // endregion 动态规划

    public static void main(String[] args) {
        System.out.println(climbStairs1(4));
        System.out.println(climbStairs2(4));
        System.out.println(climbStairs3(4));
    }
}