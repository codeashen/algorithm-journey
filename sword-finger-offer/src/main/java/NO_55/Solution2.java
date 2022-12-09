package NO_55;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * <p>
 * 广度优先遍历
 */
@Complexity(time = "O(N) N 为树的节点数量，计算树的深度需要遍历所有节点",
        space = "O(N) 最差情况下（当树平衡时），队列 queue 同时存储 N/2 个节点")
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();   // 这一层的节点数
            for (int i = 0; i < size; i++) {   // 一次将这一层的节点遍历完
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return level;
    }
}