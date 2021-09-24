package NO_0027_Remove_Element;

/**
 * 0027. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 * <p>
 * 前移元素
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
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