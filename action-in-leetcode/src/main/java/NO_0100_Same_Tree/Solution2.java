package NO_0100_Same_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * <p>
 * 广度优先搜索
 * 时间复杂度: O(min(m, n)), 其中 m 和 n 分别是两个二叉树的节点数。
 * 空间复杂度: O(min(m, n))
 */
class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null || p.val != q.val)
            return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val)
                return false;
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            // 异或运算，判断空值情况
            if (left1 == null ^ left2 == null || right1 == null ^ right2 == null)
                return false;
            if (left1 != null) {
                queue1.offer(left1);
                queue2.offer(left2);    // 经过异或判断，left2 != null 也成立
            }
            if (right2 != null) {
                queue1.offer(right1);
                queue2.offer(right2);   // 经过异或判断，right2 != null 也成立
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}