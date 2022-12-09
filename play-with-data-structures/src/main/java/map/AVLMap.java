package map;

import avl.AVLTree;

/**
 * 基于 AVL树 的映射实现
 *
 * @param <K>
 * @param <V>
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    /**
     * 键值对类，存放在AVL树中的元素
     *
     * @param <K>
     * @param <V>
     */
    private class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Entry<K, V> o) {
            return this.key.compareTo(o.key);
        }
    }

    /**
     * 底层AVL树
     */
    private AVLTree<Entry<K, V>> avl;

    public AVLMap() {
        avl = new AVLTree<>();
    }

    @Override
    public int getSize() {
        return avl.size();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public void add(K key, V value) {
        avl.add(new Entry<>(key, value));
    }

    @Override
    public V remove(K key) {
        Entry<K, V> entry = avl.remove(new Entry<>(key, null));
        return entry == null ? null : entry.value;
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(new Entry<>(key, null));
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = avl.find(new Entry<>(key, null));
        return entry == null ? null : entry.value;
    }

    @Override
    public void set(K key, V newValue) {
        Entry<K, V> entry = avl.find(new Entry<>(key, null));
        if (entry == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        entry.value = newValue;
    }
}
