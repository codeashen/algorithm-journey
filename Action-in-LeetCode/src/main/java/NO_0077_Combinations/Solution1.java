package NO_0077_Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0077. 组合
 * https://leetcode-cn.com/problems/combinations/
 * 回溯
 */
class Solution1 {
    private List<List<Integer>> res;
    
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n, k, 1, new LinkedList<>());
        return res;
    }

    /**
     * 从 [index, n] 区间中选出数字放入组合 list 中，直到组合够 k 个数字
     */
    private void dfs(int n, int k, int index, LinkedList<Integer> list) {
        // 组合中已经有 k 个元素了，加入结果集返回
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
            return;
        }

        // 还需要加入 k-list.size 个元素，还剩 n-i+1 个数字，需满足剩余数字个数大于还需个数，
        for (int i = index; n - i + 1 >= k - list.size(); i++) {
            list.add(i);
            dfs(n, k, i + 1, list);
            list.removeLast();
        }
    }
}