package heap;

public class HeapSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 构建堆过程
        // 从最后一个非叶子节点开始下沉，即最后一个元素 n-1 的父节点 ((n-1)-1)/2
        for (int i = ((n - 1) - 1) / 2; i >= 0; i--) {
            shiftDown2(arr, n, i);
        }

        // 从后向前，将元素和前面堆顶元素（即arr[0]）交换，再对前面的子数组重新 heapify
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            // 尾部元素换到 arr[0] 位置了，对 0 位置做下沉操作
            shiftDown2(arr, i, 0);
        }
    }

    /**
     * 元素下沉操作，若小于左右孩子中较大者，与其交换
     * 对 arr 第 k 个元素进行下沉，下沉范围 [0, n)
     */
    private static void shiftDown(Comparable[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            // 选出子节点中较大者
            int i = 2 * k + 1;
            if (i + 1 < n && arr[i + 1].compareTo(arr[i]) > 0) {
                i++;
            }
            // 判断是否需要下沉
            if (arr[k].compareTo(arr[i]) >= 0) {
                break;
            } else {
                swap(arr, k, i);
                k = i;
            }
        }
    }

    /**
     * 优化的shiftDown过程, 使用赋值的方式取代不断的swap, 该优化思想和我们之前对插入排序进行优化的思路是一致的。
     * 暂存目标元素，子元素逐个上移，最后腾出的位置填入暂存值。
     */
    private static void shiftDown2(Comparable[] arr, int n, int k) {
        Comparable e = arr[k];  // 暂存 k 处的元素值
        while (2 * k + 1 < n) {
            // 选出子节点中较大者
            int i = 2 * k + 1;
            if (i + 1 < n && arr[i + 1].compareTo(arr[i]) > 0) {
                i++;
            }
            // 判断是否需要下沉
            if (e.compareTo(arr[i]) >= 0) {
                break;
            } else {
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = e;  // 找到了 k 的位置，将值赋回去
    }

    /**
     * 交换堆中索引为i和j的两个元素
     */
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
