package NO_0026_Remove_Duplicates_from_Sorted_Array;

/**
 * 0026. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * 双指针
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) 
            return 0;

        // 指针含义: 元素个数; 不重复序列的下一索引
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}