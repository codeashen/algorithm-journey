package NO_0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.LinkedList;

/**
 * 0236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * 获得根节点到目标节点的路径，对比路径
 * 时间复杂度: O(N)
 * 空间复杂度: O(N)
 */
class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 查找
        LinkedList<TreeNode> path_p = findPath(root, p, new LinkedList<>());
        LinkedList<TreeNode> path_q =findPath(root, q, new LinkedList<>());

        TreeNode parent = null;
        while (true) {
            if (path_p.isEmpty() || path_q.isEmpty())
                break;
            TreeNode node_p = path_p.remove();
            TreeNode node_q = path_q.remove();
            if (node_p != node_q)
                break;
            else
                parent = node_p;
        }
        return parent;
    }

    // 查找从 root 到 node 的路径，拼到 path 中
    private LinkedList<TreeNode> findPath(TreeNode root, TreeNode node, LinkedList<TreeNode> path) {
        if (root == node) {
            path.addFirst(node);
            return path;
        }

        if (path.size() == 0 && root.left != null)
            findPath(root.left, node, path);
        if (path.size() == 0 && root.right != null)
            findPath(root.right, node, path);
        
        if (path.size() > 0)
            path.addFirst(root);

        return path;
    }
}