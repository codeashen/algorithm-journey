package NO_0047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 0047. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * <p>
 * 回溯
 * 时间复杂度: O(n×n!)
 * 空间复杂度: O(n)
 */
class Solution2 {
    private List<List<Integer>> res;
    private boolean[] used;     // 记录 nums[i] 是否已经在排列中

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);  // 必须先排序
        dfs(nums, new LinkedList<>());
        return res;
    }

    // 将有序数组 nums 的排列逐个加入 list 中
    private void dfs(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        
        // 选出一个元素，填入排列的 list，位置是 list.size()
        Integer lastChoice = null;  // 记录最后选出尝试填入 list.size() 位置的元素，注意不是排列的上一个位置 list.size() - 1
        for (int i = 0; i < nums.length; i++) {
            // (1) nums[i] 已经在排列中
            // (2) 本位置没有尝试过和 nums[i] 相同的元素，利用 nums 有序的特点，重复元素是连续的，只有第一个会被选出尝试，
            //     后续的因为 lastChoice 的限制会跳过
            if (used[i] || (lastChoice != null && nums[i] == lastChoice))
                continue;

            // 记录选择的元素
            lastChoice = nums[i];
            // 填入排列中，并继续递归回溯
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, list);
            list.removeLast();
            used[i] = false;
        }
    }
}