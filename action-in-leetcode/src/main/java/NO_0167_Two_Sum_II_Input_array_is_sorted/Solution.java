package NO_0167_Two_Sum_II_Input_array_is_sorted;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0167. 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * 双指针对撞
 */
@Complexity(time = "n", space = "1")
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 定义双指针
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            } 
        }
        throw new IllegalStateException("no result");
    }
}