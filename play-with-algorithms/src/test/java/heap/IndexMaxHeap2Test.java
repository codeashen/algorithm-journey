package heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IndexMaxHeap2Test {

    @Test
    public void test() {
        int N = 1000000;
        IndexMaxHeap2<Integer> indexMaxHeap = new IndexMaxHeap2<>(N);
        for (int i = 0; i < N; i++)
            indexMaxHeap.add(i, (int) (Math.random() * N));
        assertTrue(testIndexes2(indexMaxHeap));
    }
    
    /**
     * 测试索引堆中的索引数组index
     * 注意: 这个测试在向堆中插入元素以后, 不进行extract操作有效
     * @param heap
     * @return
     */
    private boolean testIndexes2(IndexMaxHeap2 heap) {
        int[] copyIndexes = new int[heap.count + 1];
        int[] copyReverseIndexes = new int[heap.count + 1];

        for (int i = 0; i <= heap.count; i++) {
            copyIndexes[i] = heap.indexes[i];
            copyReverseIndexes[i] = heap.reverse[i];
        }

        copyIndexes[0] = 0;
        copyReverseIndexes[0] = 0;
        Arrays.sort(copyIndexes);
        Arrays.sort(copyReverseIndexes);

        // 在对索引堆中的索引和反向索引进行排序后,
        // 两个数组都应该正好是1...count这count个索引
        boolean res = true;
        for (int i = 1; i <= heap.count; i++)
            if (copyIndexes[i - 1] + 1 != copyIndexes[i] ||
                    copyReverseIndexes[i - 1] + 1 != copyReverseIndexes[i]) {
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