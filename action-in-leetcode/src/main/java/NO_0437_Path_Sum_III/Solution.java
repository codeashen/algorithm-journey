package NO_0437_Path_Sum_III;

/**
 * 0437. 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/
 * <p>
 * 深度优先遍历，双递归
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(h)
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // 包含当前节点的结果
        int res = findPath(root, targetSum);
        // 不包含当前节点的结果
        res += pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        return res;
    }

    /**
     * 在 root 为跟的二叉树中，寻找包含 root 的路径，和为 sum
     * @param root      二叉树根节点
     * @param targetSum 路径和
     * @return 返回这样的路径个数
     */
    private int findPath(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int res = 0;
        if (targetSum == root.val)
            res += 1;
        res += findPath(root.left, targetSum - root.val);
        res += findPath(root.right, targetSum - root.val);
        return res;
    }
}