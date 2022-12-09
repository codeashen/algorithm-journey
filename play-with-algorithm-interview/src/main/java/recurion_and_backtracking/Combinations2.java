package recurion_and_backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combinations2 {

    class Solution {

        private List<List<Integer>> res;
        
        public List<List<Integer>> combine(int n, int k) {
            res = new LinkedList<>();
            dfs(n, k, 1, new LinkedList<>());
            return res;
        }

        private void dfs(int n, int k, int start, LinkedList<Integer> path) {
            if (path.size() == k) {
                res.add(new LinkedList<>(path));
                return;
            }
            // 还需要加入 k-path.size = k-start+1 个元素，还剩 n-i+1 个元素
            // 所以需要满足 n-i+1 >= k-path.size   ===>   i <= n-k+path.size+1
            for (int i = start; i <= n - k + path.size() + 1; i++) {
                path.addLast(i);
                dfs(n, k, i + 1, path);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Combinations2().new Solution();

        System.out.println(solution.combine(4, 2));
        System.out.println(solution.combine(1, 1));
    }
}
