package dynamic_programming.house_robber;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/description/
 * <p>
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
public class HouseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j <= n - 1; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 >= n ? 0 : memo[j + 2]));
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int nums[] = {1, 2};
        System.out.println((new HouseRobber2()).rob(nums));
    }
}
