package NO_0070_Climbing_Stairs;

/**
 * 0070. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 动态规划
 */
class Solution3 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int p = 1, q = 2;
        for (int i = 3; i <= n; i++) {
            q = p + q;  // 结果
            p = q - p;  // 存原来的 q
        }
        return q;
    }
}