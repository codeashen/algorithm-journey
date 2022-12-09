package NO_0120_Triangle;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * <p>
 * 记忆化搜索
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n^2)
 */
public class Solution2 {
    // memo[i][j] 表示从第 i 行第 j 个元素走到底层的最小路径和
    private Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    /**
     * 计算点 (i, j) 到底边的最短路径，其中 i 表示自上而下第几层，j 表示第几个。
     * 思路: 从点 (i, j) 到底边的最小路径，等于可达的下一层两个节点 (i+1, j) 和 (i+1, j+1) 到底边的最短路径中较小者，再加上本节点
     */
    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);
        if (memo[i][j] != null)
            return memo[i][j];
        return memo[i][j] = triangle.get(i).get(j)
                + Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1));
    }
}
