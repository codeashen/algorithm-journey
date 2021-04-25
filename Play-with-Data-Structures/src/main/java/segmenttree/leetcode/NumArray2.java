package segmenttree.leetcode;

import segmenttree.SegmentTree;

/**
 * LeetCode第303题目，区域和检索-数组不可变
 * 不使用线段树
 */
public class NumArray2 {

    /**
     * sums[i] 存储用户数组前 i 个元素的和，sums[0] = 0
     * sums[i] 存储 [0, i-1] 区间内元素的和
     */
    private int[] sums;

    public NumArray2(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
