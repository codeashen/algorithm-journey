package binary_tree_and_recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

 */
public class MaximumDepthOfBinaryTree {

    /**
     * 深度优先遍历（递归）
     * 时间复杂度: O(n)
     * 空间复杂度: O(height)
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) 
                return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    /**
     * 广度优先遍历
     * 时间复杂度: O(n)
     * 空间复杂度: 取决于队列中存储的元素，最快 O(n)
     */
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int depth = 0;
            
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                depth++;
            }
            return depth;
        }
    }

    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
}
