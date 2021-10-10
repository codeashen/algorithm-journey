package NO_0107_Binary_Tree_Level_Order_Traversal_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0107. 二叉树的层序遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * <p>
 * 广度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();    // 一次遍历一层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(0, list);   // 头插
        }
        return res;
    }
}