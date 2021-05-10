package heap;

/**
 * 1. 交换元素频繁
 * 2. 原始数组索引位置元素不可查
 */
public class IndexMaxHeap<E extends Comparable> {

    protected E[] data;      // 最大索引堆中的数据
    protected int[] indexes; // 最大索引堆中的索引
    protected int count;
    protected int capacity;

    public IndexMaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    /**
     * 向索引堆中添加元素
     *
     * @param i 添加的索引位置（因为空余元素，内部开始位置是 1，对外部而言是 0）
     * @param e 添加的元素
     */
    public void add(int i, E e) {
        assert count + 1 <= capacity;           // 确保容量
        assert i + 1 >= 1 && i + 1 <= capacity; // 确保不越界

        i++;  // 数组头部冗余空元素
        data[i] = e;
        indexes[count + 1] = i;
        count++;

        shiftUp(count);
    }

    /**
     * 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据（实际 data 没变）
     *
     * @return
     */
    public E extractMax() {
        return data[extractMaxIndex() + 1];
    }

    /**
     * 移除最大元素，返回其索引（实际 data 没变）
     *
     * @return
     */
    public int extractMaxIndex() {
        assert count > 0;

        int index = indexes[1] - 1;
        swapIndexes(1, count);
        count--;
        shiftDown(1);

        return index;
    }

    /**
     * 获取最大索引堆中索引为 index 的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        assert index + 1 >= 1 && index + 1 <= capacity;
        return data[index + 1];
    }

    /**
     * 获取最大索引堆中的堆顶元素
     *
     * @return
     */
    public E getMax() {
        return data[getMaxIndex()];
    }

    /**
     * 获取最大索引堆中的堆顶元素的索引
     *
     * @return
     */
    public int getMaxIndex() {
        assert count > 0;
        return indexes[1] - 1;
    }

    /**
     * 将最大索引堆中索引为 i 的元素修改为 e
     *
     * @param i 变更元素的索引
     * @param e 新元素
     */
    public void change(int i, E e) {
        i++;
        data[i] = e;

        // 找到索引 j, 满足 indexes[j] = i, j 表示 data[i] 在堆中的位置
        for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);  // 下沉和上浮实际只会执行一个，所以 j 不会乱
                return;
            }
        }
    }

    /**
     * 交换索引堆中索引 i 和 j
     *
     * @param i
     * @param j
     */
    private void swapIndexes(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }

    /**
     * 索引堆中，比较的是 data 数组相应位置元素的大小，实际上浮的是索引
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k]].compareTo(data[indexes[k / 2]]) > 0) {
            swapIndexes(k, k / 2);
            k /= 2;
        }
    }

    /**
     * 索引堆中，比较的是 data 数组相应位置元素的大小，实际下沉的是索引
     *
     * @param k
     */
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int i = 2 * k;
            if (i + 1 <= count && data[indexes[i + 1]].compareTo(data[indexes[i]]) > 0) {
                i++;
            }

            if (data[indexes[k]].compareTo(data[indexes[i]]) >= 0) {
                break;
            }

            swapIndexes(k, i);
            k = i;
        }
    }
}
