package NO_0230_Kth_Smallest_Element_in_a_BST;

import java.util.Stack;

/**
 * 0230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * <p>
 * 中序遍历排序，迭代法
 * 时间复杂度: O(H + k)
 * 空间复杂度: O(H + k)
 */
class Solution3 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }
}