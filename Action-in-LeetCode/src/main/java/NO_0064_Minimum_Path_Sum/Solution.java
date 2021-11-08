package NO_0064_Minimum_Path_Sum;

/**
 * 0064. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 * 动态规划
 * 时间复杂度: O(mn)
 * 空间复杂度: O(mn)
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] memo = new int[rows][columns];
        memo[0][0] = grid[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                memo[i][j] = Integer.MAX_VALUE;
                if (i - 1 >= 0) {
                    memo[i][j] = Math.min(memo[i][j], memo[i - 1][j]);
                }
                if (j - 1 >= 0) {
                    memo[i][j] = Math.min(memo[i][j], memo[i][j - 1]);
                }
            }
        }

        return memo[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
        System.out.println();
    }
}