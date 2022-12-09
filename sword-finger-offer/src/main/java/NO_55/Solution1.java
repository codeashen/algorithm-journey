package NO_55;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * <p>
 * 深度优先遍历
 */
@Complexity(time = "O(N) N 为树的节点数量，计算树的深度需要遍历所有节点",
        space = "O(N) 最差情况下（当树退化为链表时），递归深度可达到 N")
class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}