package NO_0112_Path_Sum;

/**
 * 0112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 * <p>
 * 递归，DFS
 * 时间复杂度: O(n)
 * 空间复杂度: O(h)，最坏链条 O(n)，平均 O(logn)
 */
class Solution1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            return hasPathSum(root.left, targetSum - root.val) ||
                    hasPathSum(root.right, targetSum - root.val);
        }
    }
}