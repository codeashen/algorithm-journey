package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int count;

    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    public boolean contain(K key) {
        return contain(root, key);
    }

    public V search(K key) {
        return search(root, key);
    }

    /**
     * 二分搜索树的前序遍历 O(n)
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 二分搜索树的中序遍历 O(n)
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 二分搜索树的后序遍历 O(n)
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 二分搜索树的层序遍历（广度优先遍历） O(n)
     * 思路：借助队列来实现层序遍历，先将根节点入队，再拿出队列中的节点，将其左右孩子入队，重复上述操作
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.key);

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小的键值
     *
     * @return
     */
    public K minimum() {
        assert count > 0;
        Node minimum = minimum(root);
        return minimum.key;
    }

    /**
     * 寻找二分搜索树的最大的键值
     *
     * @return
     */
    public K maximum() {
        assert count > 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    /**
     * 从二分搜索树中删除最小值所在节点
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 从二分搜索树中删除键值为 key 的节点　O(logn)
     *
     * @param key
     */
    public void remove(K key) {
        root = remove(root, key);
    }


    //region ====================== 二分搜索树辅助方法 ======================

    /**
     * 在以 node 为根节点的二分搜索树中插入节点 (key-value)，返回新的二分搜索树根节点
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    /**
     * 判断以 node 为根节点的二分搜索树中是否包含 key
     *
     * @param node
     * @param key
     * @return
     */
    private boolean contain(Node node, K key) {
        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    /**
     * 在以 node 为根的二分搜索树中查找 key
     *
     * @param node
     * @param key
     * @return
     */
    private V search(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * 前序遍历二分搜索树 node
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历二分搜索树 node
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历二分搜索树 node
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * 返回以 node 为根的二分搜索树的最小键值所在的节点
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
     * 返回以 node 为根的二分搜索树的最大键值所在的节点
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

    /**
     * 删除掉以 node 为根的二分搜索树中的最小节点
     *
     * @param node
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除掉以 node 为根的二分搜索树中的最大节点
     *
     * @param node
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除掉以 node 为根的二分搜索树中节点 key
     *
     * @param node
     * @param key
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况，使用前驱或后继处理
            Node successor = minimum(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);  // removeMin 方法里已经 count-- 了

            node.left = node.right = null;
            return node;
        }
    }

    //endregion
}
