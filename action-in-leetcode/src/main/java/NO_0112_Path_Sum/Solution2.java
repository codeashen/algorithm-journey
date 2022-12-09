package NO_0112_Path_Sum;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 * <p>
 * 广度优先遍历
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<TreeNode> queNode = new LinkedList<>();   // 存节点
        Queue<Integer> queVal = new LinkedList<>();     // 存到对应节点经过的路径和
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll(); // 达到的节点
            int value = queVal.poll();      // 到达该节点经过的路径和
            // 如果到叶子节点了，判断经过的路径和
            if (node.left == null && node.right == null) {
                if (value == targetSum)
                    return true;
                continue;
            }
            // 没到达叶子节点，存入子节点，和到达子节点经过的路径和
            if (node.left != null) {
                queNode.offer(node.left);
                queVal.offer(value + node.left.val);
            }
            if (node.right != null) {
                queNode.offer(node.right);
                queVal.offer(value + node.right.val);
            }
        }
        return false;
    }
}