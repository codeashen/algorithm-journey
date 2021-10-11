package NO_0257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * <p>
 * 广度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<String> quePath = new LinkedList<>();
        queNode.offer(root);
        quePath.offer(String.valueOf(root.val));

        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll();
            String path = quePath.poll();
            if (node.left == null && node.right == null)
                paths.add(path);

            if (node.left != null) {
                queNode.offer(node.left);
                quePath.offer(path + "->" + node.left.val);
            }
            if (node.right != null) {
                queNode.offer(node.right);
                quePath.offer(path + "->" + node.right.val);
            }
        }

        return paths;
    }
}