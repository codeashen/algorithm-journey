package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树基本实现
 *
 * @param <E> 树中的元素类型必须是可比较的，实现 Comparable 接口
 */
public class BinarySearchTree<E extends Comparable<E>> {

    /**
     * 二分搜索树存放元素的节点类
     */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
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
     * 向二分搜索树中添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以 node 为根节点的二分搜索树中添加元素 e，返回新的树
     *
     * @param node 目标树的根节点
     * @param e    待添加元素
     * @return 返回插入后的新树
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        // 不考虑相同元素的情况
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
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

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以 node 为根节点的二分搜索树
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历（非递归实现，利用栈的特性）
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            // 栈后进先出，所以先压入右孩子，再压入左孩子
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 二分搜索树的层序遍历
     * 一层一层的遍历节点，利用队列实现
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 查找二分搜索树的最小元素
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("Binary search tree is empty.");
        }
        return minimum(root).e;
    }

    /**
     * 返回以 node 为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 查找二分搜索树的最大元素
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("Binary search tree is empty.");
        }
        return maximum(root).e;
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以 node 为根的二分搜索树中的最小节点，
     * 思想就是删除最小节点，然后将最小节点的右子树替换当前子树即可
     *
     * @param node
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        // 最终情况：以node为根节点的树没有左子树，则根节点就是最小节点，将右子树替换现在的树即可
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        // 不是小节点时，继续递归调用，将左子树变成递归调用的返回子树
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点, 返回最大值
     *
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以 node 为根的二分搜索树中的最大节点，返回删除节点后新的二分搜索树的根。
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        // 最终情况：以node为根节点的树没有右子树，则根节点就是最大节点，将左子树替换现在的树即可
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        // 不是大节点时，继续递归调用，将右子树变成递归调用的返回子树
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为 e 的节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除掉以 node 为根的二分搜索树中值为 e 的节点, 递归算法
     *
     * @param node
     * @param e
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.left = remove(node.right, e);
            return node;
        } else {  // e.compareTo(node.e) == 0

            // 待删除节点的左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点的右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点的左右子树均不为空的情况

            // 找到待删除节点的前驱节点（小于本节点的最大节点 predecessor），用这个节点顶替待删除节点位置
            Node predecessor = maximum(node.left);
            predecessor.left = removeMax(node.left);
            predecessor.right = node.right;

            node.left = node.right = null;
            return predecessor;
        }
    }

    /**
     * 返回以 node 为根的二分搜索树的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    @Override
    public String toString() {
        return print(root);
    }

    private String print(Node node) {
        if (node == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        // 打印左节点
        if (node.left != null) {
            res.append("(");
            res.append(print(node.left));
            res.append(")");
        }
        // 打印根
        res.append(" ").append(node.e).append(" ");
        // 打印右节点
        if (node.right != null) {
            res.append("(");
            res.append(print(node.right));
            res.append(")");
        }
        return res.toString();
    }
}
