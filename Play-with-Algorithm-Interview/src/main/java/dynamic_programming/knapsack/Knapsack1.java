package dynamic_programming.knapsack;

/**
 * 背包问题
 * 记忆化搜索
 * 时间复杂度: O(n*C) 其中 n 为物品个数; C 为背包容积
 * 空间复杂度: O(n*C)
 */
public class Knapsack1 {

    // memo[i][c] 表示将 [0...i] 范围内的物品放入容量 c 的背包的最大价值
    private int[][] memo;

    /**
     * 求解背包问题
     *
     * @param w w[i] 表示第 i 号物品重量
     * @param v v[i] 表示第 i 号物品价值
     * @param C 背包容量
     * @return 返回可放置的最大价值
     */
    public int knapsack(int[] w, int[] v, int C) {
        if (w == null || v == null || w.length != v.length || C < 0) {
            throw new IllegalArgumentException("Invalid param.");
        }

        int n = w.length;
        if (n == 0 || C == 0) {
            return 0;
        }

        memo = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(w, v, w.length - 1, C);
    }

    /**
     * 考虑将 [0...index] 个物品放进容量为 c 的背包，使价值最大
     *
     * @param w     物品重量
     * @param v     物品价值
     * @param index 考虑的物品范围 [0...index]
     * @param c     容量限制
     * @return 返回可放置的最大价值
     */
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (c <= 0 || index < 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }

        // 情况一：index 号物品不不放入
        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            // 情况二：index 号物品放入
            int otherRes = v[index] + bestValue(w, v, index - 1, c - w[index]);
            res = Math.max(res, otherRes);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println(new Knapsack1().knapsack(w, v, C));  // 22
    }
}
