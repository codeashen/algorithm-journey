package NO_0230_Kth_Smallest_Element_in_a_BST;

import java.util.ArrayList;
import java.util.List;

/**
 * 0230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * <p>
 * 中序遍历排序，递归法
 * 时间复杂度: O(N)
 * 空间复杂度: O(N)
 */
class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = inOrder(root, new ArrayList<>());
        return list.get(k - 1);
    }
    
    private List<Integer> inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
        return list;
    }
}