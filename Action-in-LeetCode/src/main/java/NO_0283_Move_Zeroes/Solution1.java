package NO_0283_Move_Zeroes;

/**
 * 0283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * 原地移动，填充零
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution1 {
    public void moveZeroes(int[] nums) {
        // 标识临界索引
        int k = 0;
        // 第一次完全遍历，将非 0 元素填充到前面，同时维护 k
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        // 从 k 开始遍历，填充 0
        for (int j = k; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}