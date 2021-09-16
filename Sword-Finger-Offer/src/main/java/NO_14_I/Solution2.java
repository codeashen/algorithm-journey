package NO_14_I;

import java.util.Arrays;

/**
 * 剑指 Offer 14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * <p>
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
class Solution2 {
    
    public int cuttingRope(int n) {
        // memo[i] 表示长度为 i 的绳子切割能得到的最大乘积
        int[] memo = new int[n + 1];
        memo[1] = 1;
        
        for (int i = 2; i <= n; i++) {          // i 表示从小到大求 memo[i]
            for (int j = 1; j <= i - 1; j++) {  // j 表示绳子切割的第一段长度，有 i-1 种切法
                // 这里需要对比三个数
                // (1) 当前的 memo[i]
                // (2) 只分割成两个数  j * (i-j)
                // (3) 分割三个及以上  j * integerBreak(i-j) 
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}