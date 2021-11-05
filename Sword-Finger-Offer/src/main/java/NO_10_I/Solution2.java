package NO_10_I;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * <p>
 * 动态规划
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
class Solution2 {
    public int fib(int n) {
        if (n < 2) return n;
        final int MOD = 1000000007;
        int p = 0, q = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (p + q) % MOD;
            p = q;
            q = res;
        }
        return res;
    }
}
