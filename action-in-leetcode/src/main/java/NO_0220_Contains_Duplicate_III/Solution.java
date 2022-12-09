package NO_0220_Contains_Duplicate_III;

import java.util.TreeSet;

/**
 * 0220. 存在重复元素 III
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * <p>
 * 滑动窗口 + TreeSet
 * 时间复杂度: 时间复杂度: O(nlogk)
 * 空间复杂度: O(k)
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 在窗口内查找元素 v，满足 nums[i] - t <= v <= nums[i] + t
            // (1) 找到窗口查找表查找满足 v >= nums[i] - t 的最小元素
            Long ceiling = treeSet.ceiling((long) nums[i] - (long) t);  
            // (2) 如果第一步找到元素 v，并且元素还满足 v <= nums[i] + t，则找到了满足的元素
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }

            treeSet.add((long) nums[i]);
            if (treeSet.size() > k)
                treeSet.remove((long) nums[i - k]);
        }
        return false;
    }
}