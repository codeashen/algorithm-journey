package redblacktree;

/**
 * 红黑树的简单实现
 * <p>
 * 实现方式采用左倾红黑树的方式（对应2-3树中3节点的左边元素为红色节点）。
 * 不涉及删除节点操作（过于复杂）
 *
 * @param <E>
 */
public class RedBlackTree<E extends Comparable<E>> {

    /**
     * 节点颜色
     */
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * 红黑树中节点类
     */
    private class Node {
        public E e;
        public Node left, right;
        public boolean color;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断节点 node 的颜色
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        return node == null ? BLACK : node.color;
    }

    /**
     * 左旋转
     * 给黑节点添加一个红色的右孩子后，要调换两个节点的位置，保证红节点的左倾斜性
     * <pre>
     *    node                     x
     *   /   \     左旋转         /  \
     *  T1   x   --------->   node   T3
     *      / \              /   \
     *     T2 T3            T1   T2
     * </pre>
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node x = node.right;
        // 左旋转操作
        node.right = x.left;
        x.left = node;
        // 颜色维护，根节点保持和原来根节点颜色一致，旋转成为左孩子的 node 节点为红色
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 右旋转
     * <pre>
     *      node                   x
     *     /   \     右旋转       /  \
     *    x    T2   ------->   y   node
     *   / \                       /  \
     *  y  T1                     T1  T2
     * </pre>
     *
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {
        Node x = node.left;
        // 右旋转操作
        node.left = x.right;
        x.right = node;
        // 颜色维护
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 颜色翻转
     *
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 向红黑树中添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
        // 始终保持红黑树的根节点是黑色的
        root.color = BLACK;
    }

    /**
     * 向以 node 为根节点的红黑树中添加元素 e，返回新树的根
     *
     * @param node 目标树的根节点
     * @param e    待添加元素
     * @return 返回插入后新树的根
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);  // 默认插入红色节点
        }
        // 不考虑相同元素的情况
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        // 节点维护操作，可结合 README.md 中红黑树添加元素图示理解
        if (isRed(node.right) && !isRed(node.left)) {
            leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    /**
     * 判断是否包含指定元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 判断以 node 为根节点的二分搜索树是否包含指定元素 e
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }
}
