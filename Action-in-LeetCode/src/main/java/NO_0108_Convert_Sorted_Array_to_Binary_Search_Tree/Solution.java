package NO_0108_Convert_Sorted_Array_to_Binary_Search_Tree;

/**
 * 0108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * <p>
 * 中序遍历特点，选取区间中点作为根节点
 * 时间复杂度: O(N)
 * 空间复杂度: O(logN)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 将有序数组 nums[l...r] 区间转换为二叉搜索树
     */
    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);

        // 选取中点作为根节点
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }
}