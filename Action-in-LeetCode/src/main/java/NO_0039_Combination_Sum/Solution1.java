package NO_0039_Combination_Sum;

import java.util.LinkedList;
import java.util.List;

/**
 * 0039. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 * <p>
 * 二叉树回溯
 */
class Solution1 {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        dfs(candidates, target, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int idx, LinkedList<Integer> list) {
        // target == 0, 组合总和够了，组合加入结果集，返回
        if (target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        // target 负数，表示组合总和已经超了，或者 idx 已经越界，直接返回
        if (target < 0 || idx == candidates.length) return;

        // ① candidates[idx] 不加入组合
        dfs(candidates, target, idx + 1, list);
        // ② candidates[idx] 加入组合（如果超过了，就没必要加入了）
        if (candidates[idx] <= target) {
            list.addLast(candidates[idx]);
            dfs(candidates, target - candidates[idx], idx, list);
            list.removeLast();
        }
    }
}