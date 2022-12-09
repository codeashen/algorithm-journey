package NO_0046_Permutations;

import java.util.LinkedList;
import java.util.List;

/**
 * 0046. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * <p>
 * 回溯
 * 时间复杂度: O(n×n!)
 * 空间复杂度: O(n)
 */
class Solution {
    private List<List<Integer>> res;
    private boolean[] used;    // 记录 nums[i] 是否已经在排列中

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        used = new boolean[nums.length];
        dfs(nums, new LinkedList<>());
        return res;
    }

    // 将 nums 的排列逐个加入 list 中
    private void dfs(int[] nums, LinkedList<Integer> list) {
        // 排列满了，存入结果集
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        // 选出一个元素，加入排列中
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);  // 加入排列
                used[i] = true;
                dfs(nums, list);    // 将下一个元素放到排列中
                list.removeLast();  // 回溯
                used[i] = false;
            }
        }
    }
}