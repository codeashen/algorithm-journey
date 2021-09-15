package NO_03_Repeated_Elements_in_a_Array;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 迭代交换法
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
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
