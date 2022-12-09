package binary_tree_and_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/

 */
public class BinaryTreePaths {

    /**
     * 深优先限遍历（递归）
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N^2)
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) 
                return res;

            // 如果是叶子节点，递归结束
            if (root.left == null && root.right == null) {
                res.add(String.valueOf(root.val));
                return res;
            }

            // 不是叶子节点，获取左右子树结果，并处理合并
            List<String> leftRes = binaryTreePaths(root.left);
            List<String> rightRes = binaryTreePaths(root.right);
            for (String item : leftRes)
                res.add(root.val + "->" + item);
            for (String item : rightRes)
                res.add(root.val + "->" + item);
            
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
    }
}
