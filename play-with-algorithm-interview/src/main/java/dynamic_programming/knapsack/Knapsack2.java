package dynamic_programming.knapsack;

/**
 * 背包问题
 * 动态规划
 * 时间复杂度: O(n*C) 其中 n 为物品个数; C 为背包容积
 * 空间复杂度: O(n*C)
 */
public class Knapsack2 {

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

        // memo[i][c] 表示将 [0...i] 范围内的物品放入容量 c 的背包的最大价值
        int[][] memo = new int[n][C + 1];

        // 首先确定 [0...0] 范围内物品放入背包的最大价值，只要不超过背包容量，最大价值就是 v[0]
        for (int j = 0; j <= C; j++) {   // 遍历任意容量，填充 v[0] 或 0
            memo[0][j] = j >= w[0] ? v[0] : 0;
        }
        
        for (int i = 1; i < n; i++) {       // 从第 i=1 号物品考虑，范围 [1...n-1]
            for (int j = 0; j <= C; j++) {  // 从背包容量为 0 考虑，范围 [0...C]
                // 情况一：i 号物品不放入
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]) {
                    // 情况二：i 号物品放入
                    int otherRes = v[i] + memo[i - 1][j - w[i]];
                    memo[i][j] = Math.max(memo[i][j], otherRes);  // 取较大值
                }
            }
        }

        return memo[n - 1][C];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println(new Knapsack2().knapsack(w, v, C));  // 22
    }
}
