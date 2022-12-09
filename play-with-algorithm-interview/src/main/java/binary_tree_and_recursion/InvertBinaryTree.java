package binary_tree_and_recursion;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    /**
     * 递归翻转二叉树
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) 
                return root;
            
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }


    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
    }
}
