package NO_0129_Sum_Root_to_Leaf_Numbers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0129. 求根节点到叶节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * <p>
 * 广度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution2 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queSum = new LinkedList<>();
        queNode.offer(root);
        queSum.offer(root.val);

        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll();
            Integer currSum = queSum.poll();
            if (node.left == null && node.right == null) {
                sum += currSum;
                continue;
            }
            if (node.left != null) {
                queNode.offer(node.left);
                queSum.offer(currSum * 10 + node.left.val);
            }
            if (node.right != null) {
                queNode.offer(node.right);
                queSum.offer(currSum * 10 + node.right.val);
            }
        }

        return sum;
    }
}