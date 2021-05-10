package heap;

public class HeapSort2 {

    /**
     * sort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
     * 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为 O(nlogn)
     * 整个堆排序的整体时间复杂度为 O(nlogn)
     *
     * @param arr
     */
    public static void sort1(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);
        // 逐个添加
        for (Comparable comparable : arr) {
            maxHeap.add(comparable);
        }
        // 逐个取出, 倒叙填入
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    /**
     * sort2, 借助我们的 heapify 过程创建堆
     * 此时, 创建堆的过程时间复杂度为 O(n), 将所有元素依次从堆中取出来, 实践复杂度为 O(nlogn)
     * 堆排序的总体时间复杂度依然是 O(nlogn), 但是比 sort1 性能更优, 因为创建堆的性能更优
     *
     * @param arr
     */
    public static void sort2(Comparable[] arr) {
        int n = arr.length;
        // 直接构建堆
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);
        // 逐个取出, 倒叙填入
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}
