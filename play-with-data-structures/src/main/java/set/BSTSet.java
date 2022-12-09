package set;

import binarysearchtree.BinarySearchTree;

/**
 * 基于二分搜索树的集合基本实现
 * <p>时间复杂度的 O(h), 其中 h 为二分搜索数的高度, 
 * 元素个数 n=2^h-1, 即 h=log2(n+1),
 * 所以时间复杂度为 O(log n), 效率较好</p>
 *
 * @param <E>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    /**
     * 二分搜索树成员
     */
    private BinarySearchTree<E> binarySearchTree;

    public BSTSet() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @Override
    public int getSize() {
        return binarySearchTree.size();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }

    @Override
    public void add(E e) {
        binarySearchTree.add(e);
    }

    @Override
    public void remove(E e) {
        binarySearchTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }
}
