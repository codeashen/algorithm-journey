package NO_0111_Minimum_Depth_of_Binary_Tree;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * 深度优先遍历
 * 时间复杂度: O(N)
 * 空间复杂度: O(H)，平均情况下为 O(logN)
 */
class Solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}