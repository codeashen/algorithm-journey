package dynamic_programming.lis;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */
public class LongestIncreasingSubsequence1 {

    public int lengthOfLIS(int[] nums) {
        // memo[i] 表示以 nums[i] 结尾的最长上升子序列的长度，初始为 1，表示只包含自己
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        // 逐个考察以 nums[i] 结尾的最长上升子序列
        for (int i = 1; i < nums.length; i++) {
            // 逐个考察 nums[i] 前面的元素是否能和 nums[i] 构成上升序列
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        // 选出最长的
        int res = memo[0];
        for (int item : memo) {
            res = Math.max(res, item);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence1 solution = new LongestIncreasingSubsequence1();

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
