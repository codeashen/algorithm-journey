package NO_0113_Path_Sum_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * <p>
 * 深度优先遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(h)
 */
class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        
        // 如果是子节点
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                List<Integer> path = new LinkedList<>();
                path.add(root.val);
                paths.add(path);
            }
            return paths;
        }
        
        // 左子树路径
        List<List<Integer>> leftPaths = pathSum(root.left, targetSum - root.val);
        List<List<Integer>> rightPaths = pathSum(root.right, targetSum - root.val);
        
        // 左右子树路径合并
        for (List<Integer> leftPath : leftPaths) {
            leftPath.add(0, root.val);
            paths.add(leftPath);
        }
        for (List<Integer> rightPath : rightPaths) {
            rightPath.add(0, root.val);
            paths.add(rightPath);
        }

        return paths;
    }
}