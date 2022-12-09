package segmenttree.leetcode;

import com.journey.algorithm.common.annotation.LeetCode;
import segmenttree.SegmentTree;

@LeetCode(id = 303, title = "区域和检索-数组不可变", solution = "使用线段树")
public class NumArray1 {

    private SegmentTree<Integer> segmentTree;

    public NumArray1(int[] nums) {
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
