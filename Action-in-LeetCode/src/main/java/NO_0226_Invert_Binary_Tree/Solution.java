package NO_0226_Invert_Binary_Tree;

/**
 * 0226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * <p>
 * 递归翻转二叉树
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) 
            return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}