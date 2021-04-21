package map;

/**
 * 映射接口
 *
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> {
    /**
     * 获取映射对数
     *
     * @return
     */
    int getSize();

    /**
     * 判断是否额为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 向映射中添加元素
     *
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 根据键删除
     *
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 是否包含键
     *
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 根据键获取值
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 重新设置键的值
     *
     * @param key
     * @param value
     */
    void set(K key, V value);
}
