package array.leetcode;

import java.util.Arrays;

/**
 * LeetCode 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class SortColors {

    /**
     * 计数排序的思路, 对整个数组遍历了两遍
     * 时间复杂度: O(n)
     * 空间复杂度: O(k), k 为元素的取值范围, 可以视为 O(1)
     */
    public static void solution1(int[] nums) {
        int[] count = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }

    /**
     * 三路快速排序的思想, 对整个数组只遍历了一遍
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public static void solution2(int[] nums) {
        int zero = -1;          // [0...zero] == 0
        int two = nums.length;  // [two...n-1] == 2
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, i, zero + 1);
                zero++;
                i++;
            } else {  // nums[i] == 2
                swap(nums, i, two - 1);
                two--;
                // 这种情况索引 i 不变
            }
        }
    }

    /**
     * 摘抄自 leetcode 评论区，一次遍历
     * 用三个数字记录了每一种数字的索引位
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public static void solution3(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if (nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            } else {
                nums[num2++] = 2;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 2, 2, 1, 1, 0};
        solution3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
