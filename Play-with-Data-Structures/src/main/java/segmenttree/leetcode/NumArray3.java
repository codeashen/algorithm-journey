package segmenttree.leetcode;

/**
 * LeetCode第307题目，区域和检索-数组可修改
 * 解法：每次更新的时候都重新维护下 sums 数组，时间复杂度 O(n)，提交给 LeetCode 超时不通过
 */
@Deprecated
public class NumArray3 {

    /**
     * 数据数组的副本
     */
    private int[] data;
    /**
     * sums[i] 存储用户数组前 i 个元素的和，sums[0] = 0
     * sums[i] 存储 [0, i-1] 区间内元素的和
     */
    private int[] sums;

    public NumArray3(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }

        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        data[index] = val;
        // 同时更新 sums 数组
        for (int i = index + 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + data[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
