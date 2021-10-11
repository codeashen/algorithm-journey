package NO_0129_Sum_Root_to_Leaf_Numbers;

/**
 * 0129. 求根节点到叶节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * <p>
 * 深度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(h)
 */
class Solution1 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}