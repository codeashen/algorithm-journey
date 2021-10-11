package NO_0101_Symmetric_Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 广度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) 
            return true;
        else if (root.left == null && root.right == null)
            return true;
        else if (root.left == null || root.right == null)
            return false;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()) {
            Deque<TreeNode> nextDeque = new LinkedList<>();  // 存放下一层的节点
            int currentLevelSize = deque.size();
            for (int i = 0; i < currentLevelSize; i = i + 2) {
                // 每次出队首位两个，进行对比
                TreeNode p = deque.removeFirst();
                TreeNode q = deque.removeLast();
                // 检查值是否对称
                if (p.val != q.val)
                    return false;
                // 检查 p、q 的子节点 null 是否对称
                if (p.left == null ^ q.right == null || p.right == null ^ q.left == null)
                    return false;
                // 存放下一层节点
                if (p.left != null) {
                    nextDeque.addFirst(p.left);
                    nextDeque.addLast(q.right);
                }
                if (p.right != null) {
                    nextDeque.addFirst(p.right);
                    nextDeque.addLast(q.left);
                }
            }
            deque = nextDeque;
        }
        return true;
    }
}