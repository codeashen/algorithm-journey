package NO_0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

/**
 * 0235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 递归
 * 时间复杂度: O(logN)
 * 空间复杂度: O(H)
 */
class Solution3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果 p、q 落在一侧，继续向下递归
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // 递归结束条件， p、q 不在一侧，此时 root 就是最近公共祖先
            return root;  
        }
    }
}