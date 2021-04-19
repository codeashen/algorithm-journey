package linkedlist;

import java.util.Objects;

/**
 * 单链表的递归实现，链表中方法使用递归实现
 *
 * @param <E>
 */
public class RecursionLinkedList<E> {

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
     * 虚拟头节点
     */
    private Node dummyHead;
    private int size;

    public RecursionLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入节点
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        dummyHead.next = add(index, e, dummyHead.next);
        size++;
    }

    /**
     * 在以node为头节点的链表，index位置，插入e
     * 思想：在子链表头布插入节点
     *
     * @param index 插入索引
     * @param e     元素
     * @param node  头节点
     * @return 返回新的链表
     */
    private Node add(int index, E e, Node node) {
        // 最小的情况，在链表头插入节点
        if (index == 0) {
            return new Node(e, node);
        }
        // 继续获得子链表，位置-1，看是否是在头部添加
        // 把得到的子链表接到当前节点后面
        node.next = add(--index, e, node.next);
        // 返回新链表
        return node;
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
        Node node = get(index, dummyHead.next);
        return node.e;
    }

    /**
     * 递归查找指定位置的节点
     *
     * @param index 查找的节点位置
     * @param node  链表头节点
     * @return 当 index=0 时返回当前节点，否则继续递归调用
     */
    private Node get(int index, Node node) {
        if (index == 0) {
            return node;
        }
        return get(--index, node.next);
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
        Node node = get(index, dummyHead.next);
        node.e = e;
    }

    /**
     * 判断链表是否包含指定元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(e, dummyHead.next);
    }

    /**
     * 递归判断链表中是否包含指定元素
     *
     * @param e    指定元素
     * @param node 链表头节点
     * @return 当前节点符合，返回true，到链表结束还没找到，返回false
     */
    private boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        }
        if (node.e == e) {
            return true;
        } else {
            return contains(e, node.next);
        }
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
        Node delNode = remove(index, dummyHead);
        size--;
        return delNode.e;
    }

    /**
     * 移除指定位置的节点，递归实现
     *
     * @param index 要移除的节点位置
     * @param node  子链表前驱节点
     * @return
     */
    private Node remove(int index, Node node) {
        // 问题转换为移除子链表的头节点
        if (index == 0) {
            Node delNode = node.next;
            node.next = node.next.next;
            return delNode;
        }
        return remove(--index, node.next);
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
