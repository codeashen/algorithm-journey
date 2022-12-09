package stack_queue.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

    /**
     * 递归法
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postorderTraversal(root, res);
            return res;
        }

        private void postorderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }

    /**
     * 迭代法，栈
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    prev = root;
                    res.add(root.val);
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
}

