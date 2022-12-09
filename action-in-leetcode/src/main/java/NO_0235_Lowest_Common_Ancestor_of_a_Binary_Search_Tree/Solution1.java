package NO_0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.ArrayList;
import java.util.List;

/**
 * 0235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 迭代，两次查找
 */
@Complexity(time = "n", space = "n")
class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 获得 root 到 p、q 的路径
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        // 对比两条路径，找到最后一个相同的节点
        TreeNode ancestor = null;
        int step = Math.min(path_p.size(), path_q.size());
        for (int i = 0; i < step; i++) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            } 
        }
        return ancestor;
    }

    // 找出从根节 root 点到节点 target 的路径
    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val)
                node = node.left;
            else
                node = node.right;
        }
        path.add(node);
        return path;
    }
}