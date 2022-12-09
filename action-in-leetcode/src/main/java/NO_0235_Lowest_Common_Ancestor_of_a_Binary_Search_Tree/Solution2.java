package NO_0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 迭代，一次查找
 */
@Complexity(time = "n", space = "1")
class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 查找第一个分岔点
        while (true) {
            // 如果 p、q 落在同侧子树，说明没分岔，继续向下查找；否则循环结束
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}