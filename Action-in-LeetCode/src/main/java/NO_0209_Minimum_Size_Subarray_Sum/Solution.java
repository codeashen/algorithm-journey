package NO_0209_Minimum_Size_Subarray_Sum;

/**
 * 0209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * <p>
 * 滑动窗口解法
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;    // 数组长度
        int l = 0, r = -1;      // 窗口边界
        int sum = 0;            // 窗口内元素和
        int minLength = n + 1;  // 最小窗口长度

        while (l < n) {
            // 如果 sum 不够且右边界没越界，添加一个元素到窗口中，右边界向右滑
            // 如果 sum 够了，尝试从左边界拿掉一个元素，左边界右滑
            if (r + 1 < n && sum < target)
                sum += nums[++r];
            else
                sum -= nums[l--];

            // 滑动后再统计 sum 够不够，如果够则统计 res
            if (sum >= target)
                minLength = Math.min(minLength, r - l + 1);
        }

        return minLength > n ? 0 : minLength;
    }
}