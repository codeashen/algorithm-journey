package stack_queue.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 二叉树的层序遍历
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();     // 存放当前层节点
                int currentLevelSize = queue.size();         // 当前层节点数
                for (int i = 0; i < currentLevelSize; i++) { // 处理完当前层节点
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                res.add(level);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
}
