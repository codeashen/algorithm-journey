package NO_0098_Validate_Binary_Search_Tree;

/**
 * 0098. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * <p>
 * 递归
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 验证二叉搜索树，root 的值必须在 (lower, upper) 开区间内
    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}