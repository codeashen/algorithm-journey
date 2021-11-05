package NO_0039_Combination_Sum;

import java.util.LinkedList;
import java.util.List;

/**
 * 0039. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 * <p>
 * 多叉树回溯
 */
class Solution2 {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        dfs(candidates, target, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, LinkedList<Integer> list) {
        // target == 0, 组合总和够了，组合加入结果集，返回
        if (target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        // target 负数，表示组合总和已经超了，或者 begin 已经越界，直接返回
        if (target < 0 || begin == candidates.length) return;

        for (int idx = begin; idx < candidates.length; idx++) {
            if (candidates[idx] <= target) {    // 超过不加入
                list.addLast(candidates[idx]);
                dfs(candidates, target - candidates[idx], idx, list);
                list.removeLast();
            }
        }
    }
}