package NO_0404_Sum_of_Left_Leaves;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * <p>
 * 广度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 考察左子树，如果是叶子节点，累计 value，否则入队待考察
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    res += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            // 考察右子树，只有不是叶子节点的时候才入队待考察
            if (node.right != null && !isLeafNode(node.right)) {
                queue.offer(node.right);
            }
        }

        return res;
    }

    // 判断是不是叶子节点
    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}