package NO_0120_Triangle;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * <p>
 * 动态规划，自底向上递推
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n^2)
 */
public class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();  // 总行数，也表示最后一层的节点数
        // memo[i][j] 表示从点 (i, j) 到底层的最小路径和
        int[][] memo = new int[n][n];

        // 先填充最后一层所有节点到底层的最小路径和（就是自己）
        for (int j = 0; j < n; j++)
            memo[n - 1][j] = triangle.get(n - 1).get(j);

        // 倒数第二层开始，自底层向上层递推
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                memo[i][j] = triangle.get(i).get(j)
                        + Math.min(memo[i + 1][j], memo[i + 1][j + 1]);
            }
        }

        return memo[0][0];
    }
}
