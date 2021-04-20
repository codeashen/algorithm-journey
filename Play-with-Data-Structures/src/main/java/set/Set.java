package set;

/**
 * 集合接口
 *
 * @param <E>
 */
public interface Set<E> {
    /**
     * 获取元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 添加元素
     *
     * @param e
     */
    void add(E e);

    /**
     * 删除元素
     *
     * @param e
     */
    void remove(E e);

    /**
     * 是否包含指定元素
     *
     * @param e
     * @return
     */
    boolean contains(E e);
}
