package recurion_and_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * 时间复杂度: O()
 * 空间复杂度: O()
 */
public class Combinations {

    class Solution {
        private List<List<Integer>> res;  // 存放结果

        public List<List<Integer>> combine(int n, int k) {
            res = new ArrayList<>();
            dfs(n, k, 1, new LinkedList<>());
            return res;
        }

        /**
         * 求解 C(n,k)，当前已经找到的组合存储在 path 中，需要从 start 开始搜索新的元素
         *
         * @param n     区间大小 [1...n]（固定）
         * @param k     求 k 个元素的组合（固定）
         * @param start 从 start 开始往后找（递增）
         * @param path  存放组合元素（元素个数递增）
         */
        private void dfs(int n, int k, int start, LinkedList<Integer> path) {
            // 如果已经找到了 k 个元素，保存返回
            if (path.size() == k) {
                res.add(new LinkedList<>(path));  // 必须存副本
                return;
            }
            
            // 还需要加入 k-path.size 个元素，还剩 n-i+1 个元素
            // 所以需要满足 n-i+1 >= k-path.size   ===>   i <= n-k+path.size+1
            for (int i = start; i <= n - k + path.size() + 1; i++) {
                path.addLast(i);    // 向组合中加入一个元素
                dfs(n, k, i + 1, path);  // 继续递归
                path.removeLast();  // 回溯，遍历下一个
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();

        System.out.println(solution.combine(4, 2));
        System.out.println(solution.combine(1, 1));
    }
}
