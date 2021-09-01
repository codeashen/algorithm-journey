package binary_tree_and_recursion;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum {

    /**
     * 递归
     * 时间复杂度: O(n)
     * 空间复杂度: O(h)，最坏链条 O(n)，平均 O(logn)
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null)
                return false;

            // 判断是不是叶子节点
            if (root.left == null && root.right == null) {
                return targetSum == root.val;
            } else {
                return hasPathSum(root.left, targetSum - root.val)
                        || hasPathSum(root.right, targetSum - root.val);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
    }
}
