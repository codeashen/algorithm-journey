package NO_0217_Contains_Duplicate;

import java.util.HashSet;

/**
 * 0217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 * <p>
 * 查找表
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int item : nums) {
            if (set.contains(item))
                return true;
            set.add(item);
        }
        return false;
    }
}