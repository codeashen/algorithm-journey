package heap;

/**
 * 最小索引堆，首位留空
 */
public class IndexMinHeap<E extends Comparable> {

    // 最小索引堆中的数据
    private E[] data;
    // 最小索引堆中的索引, indexes[x] = i 表示索引 i 在 data 的 x 的位置
    private int[] indexes;
    // 最小索引堆中的反向索引, reverse[i] = x 表示索引 i 在 data 的 x 的位置
    private int[] reverse;
    private int count;
    private int capacity;

    /**
     * 构造方法，创建指定容量的空最小索引堆
     *
     * @param capacity
     */
    public IndexMinHeap(int capacity) {
        data = (E[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向索引堆中添加元素
     *
     * @param i 添加的索引位置（因为空余元素，内部开始位置是 1，对外部而言是 0）
     * @param e 添加的元素
     */
    public void add(int i, E e) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        // 在插入一个新元素之前，还需要保证索引 i 所在的位置是没有元素的
        assert !contain(i);

        i += 1;
        data[i] = e;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
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

        E ret = data[indexes[1]];
        // 将最后一个元素放到堆顶，再进行下沉操作
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 从最小索引堆中取出堆顶元素的索引
     *
     * @return
     */
    public int extractMinIndex() {
        assert count > 0;

        int ret = indexes[1] - 1;
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
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
        return data[indexes[1]];
    }

    /**
     * 获取最小索引堆中的堆顶元素的索引
     *
     * @return
     */
    public int getMinIndex() {
        assert count > 0;
        return indexes[1] - 1;
    }

    /**
     * 获取最小索引堆中索引为 i 的元素
     *
     * @param i
     * @return
     */
    public E getItem(int i) {
        assert contain(i);
        return data[i + 1];
    }

    /**
     * 将最小索引堆中索引为i的元素修改为newItem
     *
     * @param i
     * @param newItem
     */
    public void change(int i, E newItem) {
        assert contain(i);

        i += 1;
        data[i] = newItem;

        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    /**
     * 看索引 i 所在的位置是否存在元素
     *
     * @param i
     * @return
     */
    private boolean contain(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i + 1] != 0;
    }

    /**
     * 交换索引堆中的索引 i 和 j
     * 由于有了反向索引reverse数组，
     * indexes数组发生改变以后， 相应的就需要维护reverse数组
     *
     * @param i
     * @param j
     */
    private void swapIndexes(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    /**
     * 元素上浮操作
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) > 0) {
            swapIndexes(k, k / 2);
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
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) < 0)
                j++;

            if (data[indexes[k]].compareTo(data[indexes[j]]) <= 0)
                break;

            swapIndexes(k, j);
            k = j;
        }
    }

}
