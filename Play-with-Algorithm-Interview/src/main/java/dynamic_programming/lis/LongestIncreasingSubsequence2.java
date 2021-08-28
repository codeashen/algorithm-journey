package dynamic_programming.lis;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 记忆化搜索
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
public class LongestIncreasingSubsequence2 {

    // memo[i] 表示以 nums[i] 结尾的最长递增子序列的长度
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        
        int res = 1;
        // 逐个考察以 nums[i] 结尾的最长递增子序列的长度
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, getMaxLength(nums, i));
        }
        return res;
    }

    /**
     * 以 nums[index] 为结尾的最长上升子序列的长度
     */
    private int getMaxLength(int[] nums, int index) {
        if (memo[index] != -1) {
            return memo[index];
        }
        
        int res = 1;
        // 逐个考察 index 之前的元素是否能和 nums[index] 组成新的递增子序列
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                res = Math.max(res, 1 + getMaxLength(nums, i));
            }
        }

        memo[index] = res;
        return res;
    }
    

    public static void main(String[] args) {
        LongestIncreasingSubsequence2 solution = new LongestIncreasingSubsequence2();

        int nums1[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums1));  // 4

        int nums2[] = {4, 10, 4, 3, 8, 9};
        System.out.println(solution.lengthOfLIS(nums2));  // 3

        int nums3[] = {2, 2};
        System.out.println(solution.lengthOfLIS(nums3));  // 1

        int nums4[] = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(solution.lengthOfLIS(nums4));  // 6
    }
}
