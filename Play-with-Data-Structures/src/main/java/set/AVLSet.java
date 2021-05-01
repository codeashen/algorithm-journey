package set;

import avl.AVLTree;

/**
 * 基于 AVL树 的集合实现
 *
 * @param <E>
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    /**
     * 底层 AVL树
     */
    private AVLTree<E> avl;

    public AVLSet() {
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
    public void add(E e) {
        avl.add(e);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }
}
