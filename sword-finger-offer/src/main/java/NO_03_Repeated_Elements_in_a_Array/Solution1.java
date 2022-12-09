package NO_03_Repeated_Elements_in_a_Array;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.HashSet;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 哈希表
 */
@Complexity(time = "N", space = "1")
class Solution1 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return num;
        }
        return -1;
    }
}
