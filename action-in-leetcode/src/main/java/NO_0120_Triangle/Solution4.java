package NO_0120_Triangle;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * <p>
 * 动态规划，自顶向下递推
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n^2)
 */
public class Solution4 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();  // 总行数，也表示最后一层的节点数
        // memo[i][j] 表示从顶点 (0, 0) 到点 (i, j) 的最小路径和
        int[][] memo = new int[n][n];

        memo[0][0] = triangle.get(0).get(0);
        // 从第 i = 1 层开始，自顶向下递推
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                // (i, j) 只能从上一层 (i-1, j-1) 和 (i-1, j) 过来，取其中最小路径较小着加上自己。
                // 同时注意上一层元素角标在 [0, i-1] 区间内，注意 j-1 和 j 不能越界
                int topLeft = j - 1 < 0 ? Integer.MAX_VALUE : memo[i - 1][j - 1];
                int topRight = j > i - 1 ? Integer.MAX_VALUE : memo[i - 1][j];
                memo[i][j] = Math.min(topLeft, topRight) + triangle.get(i).get(j);
            }
        }
        
        // 遍历从顶层到最后一层所有节点的最小路径和，选出其中最小的
        int res = memo[n - 1][0];
        for (int j = 0; j < n; j++)
            res = Math.min(res, memo[n - 1][j]);

        return res;
    }
}
