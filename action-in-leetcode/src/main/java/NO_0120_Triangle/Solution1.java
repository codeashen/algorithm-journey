package NO_0120_Triangle;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * <p>
 * 暴力递归
 */
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    /**
     * 计算点 (i, j) 到底边的最短路径，其中 i 表示自上而下第几层，j 表示第几个。
     * 思路: 从点 (i, j) 到底边的最小路径，等于可达的下一层两个节点 (i+1, j) 和 (i+1, j+1) 到底边的最短路径中较小者，再加上本节点
     */
    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1))
                + triangle.get(i).get(j);
    }
}
