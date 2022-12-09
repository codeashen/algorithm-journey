package NO_0100_Same_Tree;

/**
 * 0100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * <p>
 * 深度优先搜索
 * 时间复杂度: O(min(m, n)), 其中 m 和 n 分别是两个二叉树的节点数。
 * 空间复杂度: O(min(m, n))
 */
class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}