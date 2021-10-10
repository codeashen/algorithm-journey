package NO_0145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 0145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * <p>
 * 迭代法，栈
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;  // 涉及到重入栈，需记录上一个遍历的节点
        while (root != null || !stack.isEmpty()) {
            // 1、左链入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 2、出栈一个
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                prev = root;
                res.add(root.val);  // 遍历访问时机
                root = null;        // 3、变换 root
            } else {
                stack.push(root);
                root = root.right;  // 3、变换 root
            }
        }

        return res;
    }
}