package NO_0077_Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0077. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
class Solution2 {
    private List<List<Integer>> res;
    
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n, k, new LinkedList<>());
        return res;
    }

    /**
     * 从 [1, n] 中选出 k 个数字，放入 list 中，直到放满。
     * 依次考察 n, n-1, n-2, ... , 1, 对于 n 考虑放入和不放入的情况。
     */
    private void dfs(int n, int k, LinkedList<Integer> list) {
        // 还需要放入 0 个元素，表示已经够了，加入结果集后返回
        if (k == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        // 如果 [1, n] 不够 k 个元素，直接返回
        if (n < k) return;

        // (1) n 不放入组合，去 [1, n-1] 中选 k 个数字放入组合
        dfs(n - 1, k, list);
        // (2) n 放入组合，去 [1, n-1] 中选 k-1 个数字放入组合
        list.add(n);
        dfs(n - 1, k - 1, list);
        list.removeLast();
    }
}