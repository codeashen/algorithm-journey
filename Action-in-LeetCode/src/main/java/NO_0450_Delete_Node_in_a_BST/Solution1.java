package NO_0450_Delete_Node_in_a_BST;

/**
 * 0450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * <p>
 * 前驱法
 * 时间复杂度: O(logN)
 * 空间复杂度: O(H)
 */
class Solution1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        
        if (key == root.val) {  // (1) 删除 root
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 找 root 的前驱节点 predecessor
            TreeNode predecessor = root.left;
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }
            // 方式一：右边子树接到 predecessor 右孩子位置（相对不平衡）
            // predecessor.right = root.right;
            // return root.left;
            // 方式二：predecessor 替换 root，删除原 predecessor（相对平衡）
            root.val = predecessor.val;
            root.left = deleteNode(root.left, predecessor.val);
            return root;
        } else if (key < root.val) {  // (2) 去左子树删除
            root.left = deleteNode(root.left, key);
            return root;
        } else {  // (3) 去右子树删除
            root.right = deleteNode(root.right, key);
            return root;
        }
    }
}