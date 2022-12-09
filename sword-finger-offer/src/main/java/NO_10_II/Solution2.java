package NO_10_II;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>
 * 动态规划
 */
@Complexity(time = "N", space = "1")
class Solution2 {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        final int MOD = 1000000007;
        int p = 1, q = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (p + q) % MOD;
            p = q;
            q = res;
        }
        return res;
    }
}
