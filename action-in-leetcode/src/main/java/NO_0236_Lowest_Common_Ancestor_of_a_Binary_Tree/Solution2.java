package NO_0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * 判断节点在子树的分布
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    // 存放最近公共祖先
    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        this.contains(root, p, q);
        return res;
    }

    /**
     * 返回二叉树 root 中是否包含 p 或 q
     *
     * @return 包含其中 p 或 q 其中一个就返回 true
     */
    private boolean contains(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        
        boolean l = contains(root.left, p, q);  // 左子树是否包含
        boolean r = contains(root.right, p, q); // 右子树是否包含
        
        // 如果左右子树都包含，说明一边一个，root 为最近公共祖先
        if (l && r) 
            res = root;
        // 如果根节点包含，另一个在子树中包含，root 为最近公共祖先
        if ((p.val == root.val || q.val == root.val) && (l || r))
            res = root;

        // 左边包含 || 右边包含 || 根节点包含
        return l || r || (p.val == root.val || q.val == root.val);
    }
}