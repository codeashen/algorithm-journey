package NO_0222_Count_Complete_Tree_Nodes;

/**
 * 0222. 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * <p>
 * 判断左右子树是否满二叉树，直接计算满子树，递归计算不满的子树
 * 时间复杂度: O((logN)^2)
 * 空间复杂度: O(1)
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        // 计算左右子树高度
        int depth1 = depth(root.left);
        int depth2 = depth(root.right);
        // 左右子树节点个数
        int count1, count2;

        // 如果左右子树高度相等，则左子树一定是满二叉树，可直接计算左子树个数，递归计算右子树
        // 否则，右子树是满二叉树，直接计算右子树个数，递归计算左子树
        if (depth1 == depth2) {
            count1 = (1 << depth1) - 1;     // 左子树满
            count2 = countNodes(root.right);
        } else {
            count1 = countNodes(root.left);
            count2 = (1 << depth2) - 1;     // 右子树满
        }
        
        // 左右子树节点个数 + 根节点 1 个
        return count1 + count2 + 1;
    }

    // 计算二叉树的高度，即统计左链节点个数
    private int depth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}