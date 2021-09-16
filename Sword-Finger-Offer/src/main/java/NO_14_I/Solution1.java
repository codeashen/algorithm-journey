package NO_14_I;

import java.util.Arrays;

/**
 * 剑指 Offer 14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * <p>
 * 记忆化搜索
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
class Solution1 {
    // memo[i] 表示长度为 i 的绳子切割能得到的最大乘积
    private int[] memo;

    public int cuttingRope(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return cutting(n);
    }

    private int cutting(int n) {
        // 递归结束条件: 绳子只有一个单位长度，不能切割了
        if (n == 1) return 1;
        
        if (memo[n] != -1) return memo[n];
        
        // 切割出第一端绳子有 n-1 种方式
        for (int i = 1; i <= n - 1; i++) {
            // 三数取最大值: (1)记忆化的值; (2)剩下部分不再切割的情况; (3)剩下部分继续切割 
            memo[n] = max3(memo[n], i * (n - i), i * cutting(n - i));
        }
        return memo[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}