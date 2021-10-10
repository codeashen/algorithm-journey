package NO_0094_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 0094. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>
 * 迭代法，栈
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 1、左链入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 2、出栈一个
            root = stack.pop();
            res.add(root.val);  // 遍历访问时机
            // 3、变换 root
            root = root.right;
        }

        return res;
    }
}