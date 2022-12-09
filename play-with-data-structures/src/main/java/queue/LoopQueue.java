package queue;

/**
 * <h1>循环队列基本实现</h1>
 * <p>
 * front指向队首元素索引，tail指向队尾元素下一个索引。
 * front == tail 表示队列为空，(tail + 1) % capacity 表示队列满。
 * capacity中故意浪费一个空间，用来区分队列空和满，即capacity=10，能放9个元素。
 *
 * <pre>示意图：
 *           f
 *    [h][ ][c][d][e][f][g]
 *        t
 * 图中循环队列已经满了</pre>
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 存放队列元素的数组
     */
    private E[] data;
    /**
     * 队首和队尾
     */
    private int front, tail;
    /**
     * 队列元素个数
     */
    private int size;

    public LoopQueue(int capacity) {
        // 比传入的 capacity 多 1，用来区分队列为空和队列满的情况
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获取队列容量
     *
     * @return
     */
    public int getCapacity() {
        // 实际容量应该除去有意空出的一个（不能存放元素）
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 如果队列满了，扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        // 因为是循环队列，注意tail的计算
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue!");
        }
        E ret = data[front];
        data[front] = null;
        // 因为是循环队列，注意front的计算
        front = (front + 1) % data.length;
        size--;
        // 元素个数过少时，进行缩容
        if (size < getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot getFront from an empty queue!");
        }
        return data[front];
    }

    /**
     * 队列扩容缩容
     *
     * @param newCapacity 新的队列容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 将原循环队列中的数据放到新数组中，重置front和tail
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        // 与 resize 稍有区别的遍历方法，效果相同
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if (i + 1 != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
