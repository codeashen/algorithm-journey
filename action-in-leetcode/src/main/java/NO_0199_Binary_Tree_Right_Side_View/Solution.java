package NO_0199_Binary_Tree_Right_Side_View;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * <p>
 * 广度优先遍历
 */
@Complexity(time = "n", space = "n")
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();    // 本层节点数
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (i == size - 1)      // 本层最后一个
                    res.add(node.val);
            }
        }

        return res;
    }
}