package linkedlist;

import java.util.Objects;

/**
 * 链表基本实现
 */
public class LinkedList<E> {

    /**
     * 链表节点实现
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 引入虚拟元头节点，为链表真正头节点的前驱节点，用以统一操作逻辑
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表指定位置插入元素
     *
     * @param index 插入位置的索引
     * @param e     插入的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        // 遍历节点，找到待插入节点的前驱节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 插入新节点
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 链表头插入元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 链表尾部插入元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取指定位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Illegal index.");
        }
        // 从真正头节点开始
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改指定位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Illegal index.");
        }
        // 从真正头节点开始
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断链表是否包含指定元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        // 另一种遍历方式
        while (cur != null) {
            if (Objects.equals(cur.e, e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 移除指定位置节点
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, Illegal index.");
        }
        // 查询待移除节点的前驱节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 移除头节点
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移除末尾节点
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 移除链表中所有指定元素节点
     *
     * @param e
     */
    public void removeElements(E e) {
        // 从链表头节点开始递归判断是否需要移除
        dummyHead.next = removeElements(dummyHead.next, e);
    }

    /**
     * 递归判断节点是否需要被移除，不需要移除就返回本身，需要移除就返回下一个节点
     * 递归将问题转换为小问题：如果链表头节点符合移除条件，就移除，返回新的头节点
     *
     * @param node 待判断是否需要移除的节点
     * @param e    需要移除的元素
     * @return 本节点不需要移除则返回本节点，需要移除则返回下一节点
     */
    private Node removeElements(Node node, E e) {
        // 考虑问题规模最小的情况（递归退出条件）
        if (node == null) {
            return null;
        }
        // 减小问题规模
        node.next = removeElements(node.next, e);
        // 判断 node 节点是否需要删除
        return Objects.equals(node.e, e) ? node.next : node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
