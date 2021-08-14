package array.leetcode.sliding_window;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinimumSizeSubarraySum {

    /**
     * 暴力枚举法
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        // 最短子数组长度
        int res = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];  // 连续子数组和
            int count = 1;      // 连续子数组长度
            for (int j = i + 1; j < nums.length; j++) {
                if (sum >= target) {
                    res = Math.min(res, count);
                    break;
                } else {
                    sum += nums[j];
                    count++;
                }
            }
            if (sum >= target) {
                res = Math.min(res, count);
            }
        }

        return res > nums.length ? 0 : res;
    }

    /**
     * 滑动窗口解法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int l = 0, r = -1;          // 滑动窗口为 nums[l...r]
        int sum = 0;                // 连续子数组和，即滑动窗口内元素和
        int res = nums.length + 1;  // 连续子数组长度，即滑动窗口元素个数

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < target) {
                // sum 不够且右边界没越界，添加一个元素到窗口中，右边界向右滑
                r++;
                sum += nums[r];
            } else {
                // sum 够了，尝试从左边界拿掉一个元素，左边界右滑
                sum -= nums[l];
                l++;
            }

            // 如果 sum 够了，统计 res
            if (sum >= target) {
                res = Math.min(res, r - l + 1);
            }
        }
       
        return res > nums.length ? 0 : res;
    }


    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));  // 2
        System.out.println(minSubArrayLen2(4, new int[]{1, 4, 4}));  // 1
        System.out.println(minSubArrayLen2(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));  // 4
    }

}
