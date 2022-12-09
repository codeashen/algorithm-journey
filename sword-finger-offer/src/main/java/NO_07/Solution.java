package NO_07;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * <p>
 * 递归
 */
@Complexity(time = "N", space = "N")
class Solution {

    // 二叉树元素在中序遍历结果中对应的索引
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        // 构建中序遍历 元素-索引 的映射
        inorderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        // 重构二叉树
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 重构二叉树的一部分，返回根节点，
     * 重构部分的前序遍历是 preorder[preorder_l...preorder_r]
     * 重构部分的中序序遍历是 inorder[inorder_l...inorder_r]
     *
     * @param preorder   二叉树的前序遍历
     * @param inorder    二叉树的中序遍历
     * @param preorder_l 重构部分前序遍历区间左端点
     * @param preorder_r 重构部分前序遍历区间右端点
     * @param inorder_l  重构部分中序遍历区间左端点
     * @param inorder_r  重构部分中序遍历区间右端点
     * @return
     */
    private TreeNode build(int[] preorder, int[] inorder,
                           int preorder_l, int preorder_r,
                           int inorder_l, int inorder_r) {
        // 创建根节点
        int rootVal = preorder[preorder_l];
        TreeNode root = new TreeNode(rootVal);
        // 递归终止条件：树只有根节点一个元素
        if (preorder_l == preorder_r) {
            return root;
        }
        // 找出根节点在中序遍历中的位置
        int inorder_root = inorderMap.get(rootVal);
        // 计算左右子树 size
        int leftSize = inorder_root - inorder_l;
        int rightSize = inorder_r - inorder_root;
        // 递归重构左右子树（注意区间划分，并且子树有元素才递归，否则数组越界）
        if (leftSize > 0) {
            root.left = build(preorder, inorder,
                    preorder_l + 1, preorder_l + leftSize,
                    inorder_l, inorder_root - 1);
        }
        if (rightSize > 0) {
            root.right = build(preorder, inorder,
                    preorder_r - rightSize + 1, preorder_r,
                    inorder_root + 1, inorder_r);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println("finish");
    }
}
