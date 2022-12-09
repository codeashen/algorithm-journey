package NO_0113_Path_Sum_II;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * <p>
 * 广度优先遍历
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;

        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<List<Integer>> quePath = new LinkedList<>();
        Queue<Integer> queSum = new LinkedList<>();
        queNode.offer(root);
        quePath.offer(new LinkedList<Integer>() {{
            add(root.val);
        }});
        queSum.offer(root.val);

        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll();
            List<Integer> path = quePath.poll();
            Integer sum = queSum.poll();
            // 如果到了子节点
            if (node.left == null && node.right == null) {
                if (sum == targetSum)
                    paths.add(path);
                continue;
            }
            // 如果左右有孩子，入队
            if (node.left != null) {
                queNode.offer(node.left);
                List<Integer> nextPath = new LinkedList<>(path);  // path 要复制一份
                nextPath.add(node.left.val);
                quePath.offer(nextPath);
                queSum.offer(sum + node.left.val);
            }
            if (node.right != null) {
                queNode.offer(node.right);
                List<Integer> nextPath = new LinkedList<>(path);  // path 要复制一份
                nextPath.add(node.right.val);
                quePath.offer(nextPath);
                queSum.offer(sum + node.right.val);
            }
        }

        return paths;
    }
}