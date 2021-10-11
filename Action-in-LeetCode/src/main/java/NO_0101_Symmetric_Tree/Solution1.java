package NO_0101_Symmetric_Tree;

/**
 * 0101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 递归
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;    // 同时为空 true
        else if (p == null || q == null)
            return false;   // 一方为空 fasle
        else if (p.val != q.val)
            return false;   // 值不相等 false
        else
            return check(p.left, q.right) && check(p.right, q.left);  // 递归检查对称性
    }
}