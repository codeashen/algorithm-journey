package stack_queue.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

    /**
     * 递归法
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorderTraversal(root, res);
            return res;
        }

        private void preorderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    /**
     * 迭代法，栈
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    res.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }
}
