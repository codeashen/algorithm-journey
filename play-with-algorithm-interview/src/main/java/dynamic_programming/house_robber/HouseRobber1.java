package dynamic_programming.house_robber;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/description/
 * <p>
 * 记忆化搜索
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
public class HouseRobber1 {

    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rangeRob(nums, 0);
    }

    /**
     * 偷取 nums[index...nums.length) 范围的房子的最大收益
     */
    public int rangeRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + rangeRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }


    public static void main(String[] args) {
        int nums[] = {1, 2};
        System.out.println((new HouseRobber1()).rob(nums));
    }
}
