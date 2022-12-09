package NO_0027_Remove_Element;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0027. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 * <p>
 * 前移元素
 */
@Complexity(time = "n", space = "1")
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}