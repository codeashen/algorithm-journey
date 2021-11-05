package NO_0047_Permutations_II;

import java.util.*;

/**
 * 0047. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * <p>
 * 回溯
 * 时间复杂度: O(n×n!)
 * 空间复杂度: O(n)
 */
class Solution1 {
    private List<List<Integer>> res;
    private boolean[] used;     // 记录 nums[i] 是否已经在排列中

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        used = new boolean[nums.length];
        dfs(nums, new LinkedList<>());
        return res;
    }

    // 将有序数组 nums 的排列逐个加入 list 中
    private void dfs(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        HashSet<Integer> tried = new HashSet<>();  // 本位置尝试过的数字
        for (int i = 0; i < nums.length; i++) {
            // (1) nums[i] 已经在排列中，跳过
            // (2) 和 nums[i] 的数字已经在本位置尝试填入过了，跳过，保证了重复数字只会被填入一次
            if (used[i] || tried.contains(nums[i]))
                continue;

            // 记录选择的数字
            tried.add(nums[i]);
            // 填入排列中，并继续递归回溯
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, list);
            list.removeLast();
            used[i] = false;
        }
    }
}