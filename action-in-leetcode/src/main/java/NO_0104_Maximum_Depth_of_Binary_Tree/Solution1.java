package NO_0104_Maximum_Depth_of_Binary_Tree;

/**
 * 0104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * <p>
 * 深度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(h)
 */
class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}