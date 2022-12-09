package NO_0102_Binary_Tree_Level_Order_Traversal;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 广度优先遍历
 */
@Complexity(time = "n", space = "n")
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();  // 一次遍历一层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) 
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}