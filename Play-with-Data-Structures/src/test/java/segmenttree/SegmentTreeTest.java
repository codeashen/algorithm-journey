package segmenttree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentTreeTest {
    
    @Test
    public void segmentTree() {
        Integer[] arr = {5, 3, 4, 9, 0, 1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (a, b) -> a + b);
        System.out.println(segmentTree);
    }

}