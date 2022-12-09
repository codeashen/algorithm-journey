package NO_13;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * <p>
 * 深度优先遍历
 */
@Complexity(time = "O(M×N), 最差情况下所有节点都需要访问",
        space = "O(M×N), 需要存储 M×N 的二维数组")
public class Solution1 {

    // 存储原始的参数
    int m, n, k;
    // visited[i][j] == true 标识矩阵 (i, j) 点访问过
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0);  // 从 (0, 0) 点开始
    }

    /**
     * 返回从 (i, j) 点可达的格子数量
     */
    private int dfs(int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0          // 排除角标越界
                || !accessible(i, j) || visited[i][j])  // 排除不满足条件和访问过的
            return 0;

        visited[i][j] = true;  // 标记访问过
        return 1 + dfs(i + 1, j) + dfs(i - 1, j)
                + dfs(i, j + 1) + dfs(i, j - 1);
    }

    /**
     * 辅助方法，判断格子 (i, j) 是否可以访问
     */
    private boolean accessible(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= this.k;
    }

}
