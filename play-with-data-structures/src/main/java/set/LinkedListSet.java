package set;

import linkedlist.LinkedList;

/**
 * 基于链表的集合基本实现
 * <p>时间复杂度的 O(n), 效率低于二分搜索树实现</p>
 *
 * @param <E>
 */
public class LinkedListSet<E extends Comparable<E>> implements Set<E> {

    /**
     * 链表成员
     */
    private LinkedList<E> linkedList;
    
    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }
    
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }
}
