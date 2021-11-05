package NO_0070_Climbing_Stairs;

/**
 * 0070. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 递归（超时）
 */
class Solution1 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}