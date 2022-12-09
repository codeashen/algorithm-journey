package NO_0230_Kth_Smallest_Element_in_a_BST;

/**
 * 0230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * <p>
 * 根据子树节点个数查找
 */
class Solution1 {
    public int kthSmallest(TreeNode root, int k) {
        // 计算 root 的左子树节点个数 count
        int count = nodeCount(root.left);

        if (count == k - 1) {  // 此时 root 就是第 k 小的节点
            return root.val;
        } else if (count > k - 1) {  // 左子树不止 k 个节点，root 大于第 k 小节点，去左子树中找
            return kthSmallest(root.left, k);
        } else {  // 左子树个数不足 k-1 个，root 小于第 k 小节点，去右子树找
            return kthSmallest(root.right, k - count - 1);
        }
    }

    // 返回二叉搜索树 root 的节点个数
    private int nodeCount(TreeNode root) {
        if (root == null) return 0;
        return nodeCount(root.left) + nodeCount(root.right) + 1;
    }
}