package NO_13;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * <p>
 * 广度优先遍历
 */
@Complexity(time = "O(M×N)", space = "O(M×N)")
public class Solution2 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int res = 0;    // 可达格子数量
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0], j = node[1];
            // 校验角标越界，是否可达，是否访问过
            if (i >= m || j >= n || !accessible(i, j, k) || visited[i][j])
                continue;

            // 可达格子 +1，标记访问过
            res++;
            visited[i][j] = true;
            // 将当前格子的右、下两个格子入队，后续考察
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i, j + 1});
        }
        return res;
    }

    /**
     * 辅助方法，判断格子 (i, j) 是否可以访问
     */
    private boolean accessible(int i, int j, int k) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }

}
