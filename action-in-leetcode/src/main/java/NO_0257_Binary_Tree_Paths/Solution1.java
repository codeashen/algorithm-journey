package NO_0257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

/**
 * 0257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * <p>
 * 深优先限遍历（递归）
 * 时间复杂度: O(n), n为树中的节点个数
 * 空间复杂度: O(h), h为树的高度
 */
class Solution1 {
    public List<String> binaryTreePaths(TreeNode root) {
        // 存放从本节点 root，到所有叶子节点的路径
        List<String> paths = new ArrayList<>();
        
        // 如果是 null，递归结束
        if (root == null) 
            return paths;
        // 如果是叶子节点，递归结束
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        }
        
        // 获取左孩子到叶子节点的所有路径
        List<String> leftPaths = binaryTreePaths(root.left);
        // 获取右孩子到所有叶子节点的路径
        List<String> rightPaths = binaryTreePaths(root.right);
        // 左右孩子的路径前面加上 root，就是 root 到所有叶子节点的路径
        for (String leftPath : leftPaths)
            paths.add(root.val + "->" + leftPath);
        for (String rightPath : rightPaths)
            paths.add(root.val + "->" + rightPath);

        return paths;
    }
}