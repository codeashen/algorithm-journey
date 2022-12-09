package NO_0111_Minimum_Depth_of_Binary_Tree;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * 广度优先遍历
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return minDepth + 1;
                if (node.left != null) 
                    queue.offer(node.left);
                if (node.right != null) 
                    queue.offer(node.right);
            }
            minDepth++;
        }

        return 0;
    }
}