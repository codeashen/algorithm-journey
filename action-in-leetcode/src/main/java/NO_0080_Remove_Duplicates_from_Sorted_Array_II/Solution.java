package NO_0080_Remove_Duplicates_from_Sorted_Array_II;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0080. 删除有序数组中的重复项 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * <p>
 * 双指针
 */
@Complexity(time = "n", space = "1")
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        
        // 指针含义：符合条件的数组下一个指针；即符合条件的数组长度
        int k = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[k - 1] || nums[k - 1] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}