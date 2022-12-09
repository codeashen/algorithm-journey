package NO_0144_Binary_Tree_Preorder_Traversal;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 0144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * 迭代法，栈
 */
@Complexity(time = "n", space = "n")
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 1、左链入栈
            while (root != null) {
                res.add(root.val);
                stack.push(root);   // 遍历访问时机
                root = root.left;
            }
            // 2、出栈一个
            root = stack.pop();
            // 3、变换 root
            root = root.right;
        }
        
        return res;
    }
}