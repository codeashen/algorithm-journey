package heap;

import array.Array;

/**
 * 最大二叉堆基本实现（数组表示形式）
 * <pre>
 * 用数组存放二叉堆元素，元素0索引不留空，元素在数组中索引关系：
 *      parent(i) = (i - 1)/2
 *      left(i) = 2*i + 1
 *      right(i) = 2*i + 2
 * </pre>
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 根据传入的数组，构造堆
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {
        // 直接赋值数组，看作是顺序不确定的堆
        data = new Array<>(arr);
        // 调整顺序，从最后一个非叶子节点开始，往根节点，依次做下沉操作，使数组符合堆的表示形式
        // 最后一个非叶子节点，就是最后一个节点的父节点，索引为 parent(arr.length - 1)
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回队中元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 判断堆中是否有元素
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        // 先将元素插入堆的尾部
        data.addLast(e);
        // 进行上浮操作，使得元素满足最大堆特性
        siftUp(data.getSize() - 1);
    }

    /**
     * 对指定元素进行上浮操作。
     * 当前节点和父节点比较，大于父节点就交换
     *
     * @param i
     */
    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(parent(i), i);
            i = parent(i);
        }
    }

    /**
     * 取出堆中最大的元素。
     * 取出堆中根节点的元素，将完全二叉树的最后一层最后一个元素放到根节点位置，再对根节点进行下沉操作
     *
     * @return
     */
    public E extractMax() {
        E max = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return max;
    }

    /**
     * 对指定元素进行下沉操作。
     * 选出左右孩子中较大者 x，如果本节点比 x 小，就交换
     *
     * @param i
     */
    private void siftDown(int i) {
        // 判断是否有左孩子，即是不是叶子节点
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            // 判断是否有右孩子 及 右孩子是否比左孩子大
            if (rightChild(i) < data.getSize()
                    && data.get(rightChild(i)).compareTo(data.get(j)) > 0) {
                j = rightChild(i);
            }
            // 此时 data[j] 是 leftChild 和 rightChild 中较大的值

            // 如果大于等于子节点，结束下沉，否则交换并继续循环
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            } else {
                data.swap(i, j);
                i = j;
            }
        }
    }

    /**
     * 查看堆中最大的元素
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can't find max when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 返回完全二叉树的数组表示中，index 索引所表示元素的父节点索引
     * parent(i) = (i - 1)/2
     *
     * @param index 指定元素的索引
     * @return 指定元素的父节点索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 取出最大的元素，插入一个新的元素
     *
     * @param e
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    /**
     * 返回完全二叉树的数组表示中，index 索引所表示元素的左子节点索引
     * left(i) = 2*i + 1
     *
     * @param index 指定元素的索引
     * @return 指定元素的左子节点索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，index 索引所表示元素的右子节点索引
     * right(i) = 2*i + 2
     *
     * @param index 指定元素的索引
     * @return 指定元素的右子节点索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }
}
