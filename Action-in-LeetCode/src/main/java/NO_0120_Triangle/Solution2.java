package NO_0120_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划
 * 从三角顶层到底层，计算节点从顶层过来的最小路径和
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n^2)
 */
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();       // n 表示行数
        int[][] memo = new int[n][n];  // meme[i][j] 表示从顶层到节点 c[i][j] 的最小路径和
        memo[0][0] = triangle.get(0).get(0);

        // 遍历行数 i，从上到下，0 -> n-1
        for (int i = 1; i < n; i++) {
            memo[i][0] = memo[i - 1][0] + triangle.get(i).get(0);  // 本层第一个元素只能从上一层的第一个节点过来
            // 本层 [1...i-1] 范围内的元素 j 可以从上层第 j-1 和第 j 个元素过来
            for (int j = 1; j < i; j++) {
                memo[i][j] = Math.min(memo[i - 1][j - 1], memo[i - 1][j]) + triangle.get(i).get(j);
            }
            memo[i][i] = memo[i - 1][i - 1] + triangle.get(i).get(i); // 本层最后一个元素只能从上一层的最后一个节点过来
        }

        // 遍历从顶点到最后一层所有节点的最小路径和，找出其中最小的
        int minTotal = memo[n - 1][0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, memo[n - 1][i]);
        }
        return minTotal;
    }
}
