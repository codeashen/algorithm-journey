package NO_0283_Move_Zeroes;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * 通过交换，不需要最后的填充 0 操作
 */
@Complexity(time = "n", space = "1")
class Solution2 {
    public void moveZeroes(int[] nums) {
        // k 指向第一个 0 元素
        int k = 0;
        // 完全遍历，如果遇到非 0 元素，和 k 指向的 0 元素交换，k++
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, i, k);
                }
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}