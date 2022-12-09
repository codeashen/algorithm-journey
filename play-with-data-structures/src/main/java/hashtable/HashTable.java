package hashtable;

import java.util.TreeMap;

/**
 * 哈希表简单实现，数组 + 红黑树(TreeMap)
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> {
    
    /**
     * 扩容因子， size / M > upperTol 时扩容
     */
    private static final int upperTol = 10;
    /**
     * 缩容因子， size / M < upperTol 时缩容
     */
    private static final int lowerTol = 2;
    /**
     * 默认容量
     */
    private static final int initCapacity = 7;

    /**
     * 底层数据结构，红黑树数组
     */
    private TreeMap<K, V>[] hashtable;
    /**
     * 哈希表大小
     */
    private int M;
    /**
     * 已存储元素个数
     */
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    private int hash(K key) {
        // 去符号取模，得索引
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            // 已存在，替换
            map.put(key, value);
        } else {
            // 新添加
            map.put(key, value);
            size++;

            if (size >= upperTol * M) {
                resize(2 * M);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;

            if (size < lowerTol * M && M / 2 > initCapacity) {
                resize(M / 2);
            }
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    /**
     * 容量调整
     *
     * @param capacity 新容量
     */
    private void resize(int capacity) {
        TreeMap<K, V>[] newHashTable = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        // 记得保存 M 旧值，并对其更新，使新的 hash 函数正确执行
        int oldM = this.M;
        this.M = capacity;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashtable = newHashTable;
    }
}
