package NO_0120_Triangle;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * <p>
 * 动态规划
 * 从三角底层到顶层，计算节点到底层的最小路径和
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n^2)
 */
class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();       // n 表示行数
        int[][] memo = new int[n][n];  // meme[i][j] 表示第 i 行第 j 号元素到底层的最小路径和

        // 遍历行数 i，从下到上，n-1 -> 0
        for (int i = n - 1; i >= 0; i--) {
            // 遍历每层元素 j, 从左到右，0 -> i
            for (int j = 0; j <= i; j++) {
                // 如果是底层元素，到底层的最小路径和就是自身
                if (i == n - 1) {
                    memo[i][j] = triangle.get(i).get(j);
                    continue;
                }
                // 不是底层元素，计算到底层的最小路径和，自身 + 下一层的最小路径和
                int left = triangle.get(i).get(j) + memo[i + 1][j];
                int right = triangle.get(i).get(j) + memo[i + 1][j + 1];
                memo[i][j] = Math.min(left, right);
            }
        }

        return memo[0][0];
    }
}
