package NO_0075_Sort_Colors;

/**
 * 0075. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 * <p>
 * 三指针，三路快排思想
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        // l 表示左侧最后一个 0；r 表示右侧第一个 2
        int l = -1, r = nums.length;
        int i = 0;  // 迭代元素索引
        while (i < r) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, ++l, i++);
            } else {  // nums[i] == 2
                swap(nums, --r, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}