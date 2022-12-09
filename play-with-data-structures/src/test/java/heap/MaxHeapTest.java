package heap;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class MaxHeapTest {

    @Test
    public void add() {
        int n = 1_000_000;

        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        verifyHeap(heap);
    }

    /**
     * 检测堆是否符合规则
     *
     * @param heap
     * @param <E>
     */
    private <E extends Comparable<E>> void verifyHeap(MaxHeap<E> heap) {
        int size = heap.size();
        System.out.println("Heap size: " + size);

        E prev = heap.extractMax();
        System.out.println("Max element of heap: " + prev);
        for (int i = 0; i < size - 1; i++) {
            E cur = heap.extractMax();
            if (cur.compareTo(prev) > 0) {
                throw new IllegalStateException("bad heap");
            }
            prev = cur;
        }

        System.out.println("Min element of heap: " + prev);
        System.out.println(heap.isEmpty() ? "Heap is empty now." : "Heap is not empty now.");
        System.out.println("Test MaxHeap completed.");
    }

    /**
     * 测试将数组转化为堆表示形式
     */
    @Test
    public void heapify() {
        Random random = new Random();
        Integer[] arr = new Integer[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = System.currentTimeMillis();
        // 使用 heapify 操作构建堆
        MaxHeap<Integer> heap1 = new MaxHeap<>(arr);

        double time2 = System.currentTimeMillis();
        // 将元素一个个加入空堆
        MaxHeap<Integer> heap2 = new MaxHeap<>();
        for (Integer num : arr) {
            heap2.add(num);
        }

        double time3 = System.currentTimeMillis();

        System.out.printf("heap1 takes %s millis\n", time2 - time1);
        System.out.printf("heap1 takes %s millis\n", time3 - time2);

        System.out.println("===================== verify heap1 =====================");
        verifyHeap(heap1);
        System.out.println("===================== verify heap2 =====================");
        verifyHeap(heap2);
    }
}