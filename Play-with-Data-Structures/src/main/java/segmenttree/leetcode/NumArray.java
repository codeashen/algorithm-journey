package segmenttree.leetcode;

import segmenttree.SegmentTree;

/**
 * LeetCode第303题目，区域和检索-数组不可变
 * 使用线段树解法
 */
public class NumArray {
    
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, Integer::sum);
        }
    }

    public int sumRange(int left, int right) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null.");
        }
        return segmentTree.query(left, right);
    }
}
