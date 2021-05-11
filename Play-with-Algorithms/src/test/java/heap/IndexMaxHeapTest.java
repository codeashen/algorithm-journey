package heap;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IndexMaxHeapTest {

    @Test
    public void test() {
        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<>(N);
        for (int i = 0; i < N; i++)
            indexMaxHeap.add(i, (int) (Math.random() * N));
        assertTrue(testIndexes(indexMaxHeap));
    }

    /**
     * 测试索引堆中的索引数组index
     * 注意: 这个测试在向堆中插入元素以后, 不进行extract操作有效
     * @param heap
     * @return
     */
    private boolean testIndexes(IndexMaxHeap heap) {
        int[] copyIndexes = new int[heap.count + 1];

        for (int i = 0; i <= heap.count; i++)
            copyIndexes[i] = heap.indexes[i];

        copyIndexes[0] = 0;
        Arrays.sort(copyIndexes);

        // 在对索引堆中的索引进行排序后, 应该正好是1...count这count个索引
        boolean res = true;
        for (int i = 1; i <= heap.count; i++)
            if (copyIndexes[i - 1] + 1 != copyIndexes[i]) {
                res = false;
                break;
            }

        if (!res) {
            System.out.println("Error!");
            return false;
        }

        return true;
    }
}