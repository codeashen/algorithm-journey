package NO_03_Repeated_Elements_in_a_Array;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">...</a>
 * <p>
 * 迭代交换法
 */
@Complexity(time = "N", space = "1")
class Solution2 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;      // 只有未经过交换指针才会 +1，所以不要用 for 循环
                continue;
            }
            if (nums[nums[i]] == nums[i])
                return nums[i];
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }
}
