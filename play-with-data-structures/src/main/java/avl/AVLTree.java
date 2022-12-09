package avl;

import java.util.ArrayList;

/**
 * AVL树基本实现
 * <p>
 * 平衡二叉树的一种，由二分搜索树实现修改而成，相比于二分搜索树，可以防止树退化成链表
 */
public class AVLTree<E extends Comparable<E>> {

    /**
     * AVL树存放元素的节点类
     */
    private class Node {
        public E e;
        public Node left, right;
        /**
         * Node所在节点的高度
         */
        private int height;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
            height = 1;  // 新创建的节点高度为 1
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
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
     * 返回AVL树中某个节点的高度 height
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 计算树中某个节点的平衡因子，平衡因子为节点左右子树的高度差。
     * ps:平衡二叉树每个节点的平衡因子不超过 1
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x

    /**
     * 对节点 y 进行向右旋转操作，返回旋转后新的根节点 x
     * <pre>
     *        y                              x
     *       / \                           /   \
     *      x   T4     向右旋转 (y)        z     y
     *     / \       - - - - - - - ->    / \   / \
     *    z   T3                       T1  T2 T3 T4
     *   / \
     * T1   T2
     *
     * 大小关系：T1 < z < T2 < x < T3 < y < T4
     * </pre>
     *
     * @param y 要旋转的根节点
     * @return 返回旋转后新的根节点
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        // 向右旋转过程
        x.right = y;
        y.left = T3;

        // 更新节点 x、y 的 height（T3 子树结构没有改变，无需维护）
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * 对节点 y 进行向左旋转操作，返回旋转后新的根节点 x
     * <pre>
     *    y                             x
     *  /  \                          /   \
     * T1   x      向左旋转 (y)       y     z
     *     / \   - - - - - - - ->   / \   / \
     *   T2  z                     T1 T2 T3 T4
     *      / \
     *     T3 T4
     *
     * 大小关系：T1 < y < T2 < x < T3 < z < T4
     * </pre>
     *
     * @param y 要旋转的根节点
     * @return 返回旋转后新的根节点
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        // 向左旋转过程
        x.left = y;
        y.right = T2;

        // 更新节点 x、y 的 height（T2 子树结构没有改变，无需维护）
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * 判断当前二叉树是否是一个二分搜索树。
     * 利用二分搜索树中序遍历后，所有元素是按顺序遍历的
     *
     * @return
     */
    public boolean isBST() {
        // 中序遍历后元素列表
        ArrayList<E> elements = new ArrayList<>();
        inOrder(root, elements);
        for (int i = 1; i < elements.size(); i++) {
            // 遍历后元素列表前面元素大于后面元素，则不是二分搜索树
            if (elements.get(i - 1).compareTo(elements.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历以 node 为根的二叉树，将元素按遍历顺序加入 elements
     *
     * @param node
     * @param elements 存放遍历结果的列表
     */
    private void inOrder(Node node, ArrayList<E> elements) {
        if (node == null) {
            return;
        }
        inOrder(node.left, elements);
        elements.add(node.e);
        inOrder(node.right, elements);
    }

    /**
     * 判断当前二叉树是否是平衡二叉树
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * 判断以 node 为根节点的二叉树是否是一个平衡二叉树。
     * 通过递归计算每一个节点的平衡因子
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
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

        // 添加完成后更新本节点高度 height, 高度为左右子树高度大者+1
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        // 维护平衡
        if (balanceFactor > 1) {
            // 1) 平衡因子 > 1，左子树高度较高，说明是在左子树添加了元素导致失去平衡
            if (getBalanceFactor(node.left) >= 0) {
                // LL: 左子树的 平衡因子 >= 0，说明左子树左边高度较高，要向右旋转本届点
                return rightRotate(node);
            } else {
                // LR: 左子树的 平衡因子 < 0，说明左子树右边高度较高
                // 先左旋转左子树，转换 LR -> LL，再右旋转本节点
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            // 2) 平衡因子 < -1，右树高度较高，说明是在右子树添加了元素导致失去平衡
            if (getBalanceFactor(node.right) <= 0) {
                // RR: 右子树的 平衡因子 <= 0，说明右子树右边高度较高，要向左旋转本节点
                return leftRotate(node);
            } else {
                // RL: 右子树的 平衡因子 > 0，说明右子树左边高度较高
                // 先右旋转右子树，转换 RL -> RR，再左旋转本节点
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
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
        return getNode(root, e) != null;
    }

    /**
     * 在以 node 为根节点的树中找元素 e 所在的节点
     *
     * @param node
     * @param e
     * @return
     */
    private Node getNode(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) == 0) {
            return node;
        } else if (e.compareTo(node.e) < 0) {
            return getNode(node.left, e);
        } else {
            return getNode(node.right, e);
        }
    }

    /**
     * 查找元素
     *
     * @param e
     * @return
     */
    public E find(E e) {
        Node node = getNode(root, e);
        return node == null ? null : node.e;
    }

    /**
     * 从二分搜索树中删除元素为 e 的节点
     *
     * @param e
     */
    public E remove(E e) {
        Node node = getNode(root, e);
        if (node != null) {
            root = remove(root, e);
            return node.e;
        }
        return null;
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

        Node retNode;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            retNode = node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            retNode = node;
        } else {  // e.compareTo(node.e) == 0

            if (node.left == null) {
                // 待删除节点的左子树为空的情况
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                // 待删除节点的右子树为空的情况
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                // 待删除节点的左右子树均不为空的情况

                // 找到待删除节点的前驱节点（小于本节点的最大节点 predecessor），用这个节点顶替待删除节点位置
                Node predecessor = maximum(node.left);
                // predecessor.left = removeMax(node.left); // 原来的 removeMax 删除方式中没有维护平衡
                predecessor.left = remove(node.left, predecessor.e);  // 递归调用 remove 方法，本方法里有维护平衡逻辑
                predecessor.right = node.right;
                node.left = node.right = null;
                retNode = predecessor;
            }
        }

        if (retNode == null) {
            return null;
        }

        // 更新 height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        // 维护平衡
        if (balanceFactor > 1) {
            if (getBalanceFactor(retNode.left) >= 0) {
                // LL: 左子树的 平衡因子 >= 0，说明左子树左边高度较高，要向右旋转本届点
                return rightRotate(retNode);
            } else {
                // LR: 左子树的 平衡因子 < 0，说明左子树右边高度较高
                // 先左旋转左子树，转换 LR -> LL，再右旋转本节点
                retNode.left = leftRotate(retNode.left);
                return rightRotate(retNode);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(retNode.right) <= 0) {
                // RR: 右子树的 平衡因子 <= 0，说明右子树右边高度较高，要向左旋转本节点
                return leftRotate(retNode);
            } else {
                // RL: 右子树的 平衡因子 > 0，说明右子树左边高度较高
                // 先右旋转右子树，转换 RL -> RR，再左旋转本节点
                retNode.right = rightRotate(retNode.right);
                return leftRotate(retNode);
            }
        }

        return retNode;
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

}
