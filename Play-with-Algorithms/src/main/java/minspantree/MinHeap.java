package minspantree;

/**
 * 最小堆，首位留空
 * <p>
 * parent(i) = i/2
 * left(i) = 2*i
 * right(i) = 2*i + 1
 */
public class MinHeap<E extends Comparable> {

    private E[] data;
    private int count;
    private int capacity;

    /**
     * 构造方法，创建指定容量的空最小堆
     *
     * @param capacity
     */
    public MinHeap(int capacity) {
        data = (E[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    /**
     * 根据传入数组构造堆
     *
     * @param arr
     */
    public MinHeap(E arr[]) {
        int n = arr.length;
        data = (E[]) new Comparable[n + 1];
        capacity = n;

        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        // 从第一个非叶子节点（count / 2）逐个下沉
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向最小堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        assert count + 1 <= capacity;
        data[count + 1] = e;
        count++;
        // 新元素进行上浮
        shiftUp(count);
    }

    /**
     * 移除并返回最小堆顶部元素，即最小元素
     *
     * @return
     */
    public E extractMin() {
        assert count > 0;
        E ret = data[1];

        // 将最后一个元素放到堆顶，再进行下沉操作
        swap(1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 获取最小堆中的堆顶元素
     *
     * @return
     */
    public E getMin() {
        assert count > 0;
        return data[1];
    }

    /**
     * 交换堆中索引为i和j的两个元素
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * 元素上浮操作
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[k].compareTo(data[k / 2]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    /**
     * 元素下沉操作
     *
     * @param k
     */
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            // 选出子结点中较小者, 与父节点交换
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) < 0) {
                j = j + 1;
            }
            swap(j, k);
            k = j;
        }
    }

}
