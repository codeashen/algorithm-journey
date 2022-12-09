package binary_tree_and_recursion;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 递归
     * 时间复杂度: O(logN)
     * 空间复杂度: O(h)
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p == null || q == null)
                throw new IllegalStateException("error state");
            if(root == null)
                return null;
            
            if (p.val < root.val && q.val < root.val)
                return lowestCommonAncestor(root.left, p, q);
            if (p.val > root.val && q.val > root.val)
                return lowestCommonAncestor(root.right, p, q);

            return root;
        }
    }

    /**
     * 迭代
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (true) {
                if (p.val < root.val && q.val < root.val) {
                    root = root.left;
                } else if (p.val > root.val && q.val > root.val) {
                    root = root.right;
                } else {
                    break;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
    }
}
