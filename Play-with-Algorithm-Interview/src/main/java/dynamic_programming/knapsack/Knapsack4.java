package dynamic_programming.knapsack;

/**
 * 背包问题
 * 动态规划，空间复杂度优化 2
 * 时间复杂度: O(n*C) 其中 n 为物品个数; C 为背包容积
 * 空间复杂度: O(C), 只使用了 C 的额外空间
 */
public class Knapsack4 {

    /**
     * 动态规划解决背包问题，空间复杂度优化 2
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
        
        int[] memo = new int[C + 1];

        // 首先确定 [0...0] 范围内物品放入背包的最大价值，只要不超过背包容量，最大价值就是 v[0]
        for (int j = 0; j <= C; j++) {   // 遍历任意容量，填充 v[0] 或 0
            memo[j] = j >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {           // 从第 i=1 号物品考虑，范围 [1...n-1]
            for (int j = C; j >= w[i]; j--) {   // 从背包容量为 C 反向考虑，范围 [w(i)...C]，小于 w(i) 时不用考虑了，因为放不下 i
                // 取不放入 i 和放入 i，两者最大值
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);   // memo[j - w[i]] 在上一轮已经求得
            }
        }

        return memo[C];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12}; 
        int C = 5;
        System.out.println(new Knapsack4().knapsack(w, v, C));  // 22
    }
}
