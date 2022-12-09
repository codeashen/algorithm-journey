package NO_0098_Validate_Binary_Search_Tree;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.Stack;

/**
 * 0098. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * <p>
 * 中序遍历
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    // 利用二分搜索树的中序遍历是顺序的特性
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> stack = new Stack<>();
        long preVal = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            // 1、左链入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 2、出栈一个
            TreeNode node = stack.pop();
            // -- 遍历时机 --
            if (node.val <= preVal) {
                return false;
            }
            preVal = node.val;
            // 3、变换 root
            root = node.right;
        }
        return true;
    }
}