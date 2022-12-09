package NO_0217_Contains_Duplicate;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.HashSet;

/**
 * 0217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 * <p>
 * 查找表
 */
@Complexity(time = "n", space = "n")
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