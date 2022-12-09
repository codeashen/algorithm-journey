package binary_tree_and_recursion;

/**
 * 437. 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/
 */
public class PathSumIII {

    /**
     * 双递归
     * 时间复杂度: O(n)
     * 空间复杂度: O(h)
     */
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null)
                return 0;

            // 结合当前节点的路径 和 不包含当前节点的路径
            return findPath(root, targetSum) +
                    pathSum(root.left, targetSum) +
                    pathSum(root.right, targetSum);
        }

        /**
         * 在 root 为跟的二叉树中，寻找包含 root 的路径，和为 sum
         * @param root      二叉树根节点
         * @param targetSum 路径和
         * @return 返回这样的路径个数
         */
        private int findPath(TreeNode root, int targetSum) {
            if (root == null) 
                return 0;
            
            int res = 0;
            if (targetSum == root.val) 
                res += 1;
            res += findPath(root.left, targetSum - root.val);
            res += findPath(root.right, targetSum - root.val);
            return res;
        }
    }

    public static void main(String[] args) {
        ///////////////////
        //  测试用例:
        // 
        //        10
        //       /  \
        //      5   -3
        //     / \    \
        //    3   2   11
        //   / \   \
        //  3  -2   1
        ///////////////////
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(-2);

        TreeNode node3 = new TreeNode(3);
        node3.left = node1;
        node3.right = node2;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node5.right = node4;

        TreeNode node6 = new TreeNode(5);
        node6.left = node3;
        node6.right = node5;

        TreeNode node7 = new TreeNode(11);
        TreeNode node8 = new TreeNode(-3);
        node8.right = node7;

        TreeNode node9 = new TreeNode(10);
        node9.left = node6;
        node9.right = node8;

        Solution solution = new PathSumIII().new Solution();
        System.out.println(solution.pathSum(node9, 8));  // 3
    }
}