package NO_0450_Delete_Node_in_a_BST;

/**
 * 0450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * <p>
 * 后继法
 * 时间复杂度: O(logN)
 * 空间复杂度: O(H)
 */
class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        
        if (key == root.val) {  // (1) 删除 root
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 找 root 的后继节点 successor
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            // 方式一：左边子树接到 successor 左孩子位置（相对不平衡）
            // successor.left = root.left;
            // return root.right;
            // 方式二：successor 替换 root，删除原 successor（相对平衡）
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
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