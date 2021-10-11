package NO_0404_Sum_of_Left_Leaves;

/**
 * 0404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * <p>
 * 深度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution1 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int res = 0;
        // 如果左子树的叶子节点，加上 value，否则加上左子树中左边叶节点的和
        res += isLeafNode(root.left) ? root.left.val : sumOfLeftLeaves(root.left);
        // 如果右子树是叶子节点，不用加，否则加上右子树中左边叶节点的和
        res += isLeafNode(root.right) ? 0 : sumOfLeftLeaves(root.right);
        return res;
    }

    // 判断是不是叶子节点
    private boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}