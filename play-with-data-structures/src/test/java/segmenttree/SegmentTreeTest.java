package segmenttree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SegmentTreeTest {

    private SegmentTree<Integer> segmentTree;

    @BeforeEach
    public void init() {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        // 求和线段树
        segmentTree = new SegmentTree<>(arr, (a, b) -> a + b);
    }

    @Test
    public void segmentTree() {
        System.out.println(segmentTree);
    }

    @Test
    public void query() {
        Integer res1 = segmentTree.query(0, 2);
        Integer res2 = segmentTree.query(2, 5);
        Integer res3 = segmentTree.query(0, 5);

        System.out.println("线段树 [0, 2] 区间结果：" + res1);
        System.out.println("线段树 [2, 5] 区间结果：" + res2);
        System.out.println("线段树 [0, 5] 区间结果：" + res3);
    }

    @Test
    public void set() {
        System.out.println(segmentTree);
        
        // index 3 元素更新 为 0  ==> {1, 2, 3, 0, 5, 6}
        segmentTree.set(3, 0);
        System.out.println(segmentTree);
    }
}