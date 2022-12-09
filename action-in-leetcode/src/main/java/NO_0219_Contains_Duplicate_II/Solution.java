package NO_0219_Contains_Duplicate_II;

import java.util.HashSet;

/**
 * 0219. 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * <p>
 * set + 滑动窗口
 * 时间复杂度: O(n)
 * 空间复杂度: O(k)
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;

        // 存放滑动窗口内的元素
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果窗口元素包含当前遍历到的元素，直接返回 true
            if (set.contains(nums[i]))
                return true;

            // 否则将当前元素加到窗口内容
            set.add(nums[i]);
            // 如果窗口元素数量超过 k 个，移除窗口左边界的元素
            if (set.size() == k + 1)
                set.remove(nums[i - k]);
        }
        return false;
    }
}