package segmenttree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentTreeTest {
    
    @Test
    public void segmentTree() {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        // 求和线段树
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (a, b) -> a + b);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}