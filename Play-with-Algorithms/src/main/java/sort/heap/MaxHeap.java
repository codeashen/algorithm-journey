package sort.heap;

/**
 * 最大二叉堆简单实现
 * <p>
 * 未实现动态扩容
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * 堆中元素数组表示，0索引留空，方便索引计算
     */
    protected E[] data;
    /**
     * 元素个数
     */
    protected int count;
    /**
     * 堆容量（未实现扩容）
     */
    protected int capacity;

    public MaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    /**
     * 构造方法，通过给定数组，构建最大堆，时间复杂度 O(n)
     * @param arr
     */
    public MaxHeap(E[] arr) {
        int n = arr.length;
        data = (E[]) new Comparable[n + 1];
        capacity = n;
        // 复制数据
        System.arraycopy(arr, 0, data, 1, n);
        count = n;
        // 从最后一个非叶子节点开始做下沉操作
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
     * 向最大堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        assert capacity > count + 1;
        data[count + 1] = e;
        count++;
        shiftUp(count);
    }

    /**
     * 移除并返回最大堆顶部元素，即最大元素
     *
     * @return
     */
    public E removeMax() {
        assert count > 0;
        E e = data[1];

        swap(1, count);
        count--;
        shiftDown(1);

        return e;
    }

    /**
     * 获取最大堆中的堆顶元素
     *
     * @return
     */
    public E getMax() {
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
     * 元素上浮操作，若大于父节点，和父节点交换
     *
     * @param k 上浮元素索引
     */
    private void shiftUp(int k) {
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    /**
     * 元素下沉操作，若小于左右孩子中较大者，与其交换
     *
     * @param k 下沉元素索引
     */
    private void shiftDown(int k) {
        while (2 * k < count) {
            // 选出子节点中较大者
            int i = 2 * k;
            if (i + 1 < count && data[i + 1].compareTo(data[i]) > 0) {
                i++;
            }
            // 判断是否需要下沉
            if (data[k].compareTo(data[i]) >= 0) {
                break;
            } else {
                swap(k, i);
                k = i;
            }
        }
    }
}
