package array.leetcode;

import java.util.Arrays;

/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static int solution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        // 含义: 元素个数; 已排好序列的下一索引
        int k = 1;
        // 已排好序列右端是否重复 2 个元素
        boolean duplicateTail = false;
        
        for (int i = k; i < nums.length; i++) {
            if (duplicateTail) {
                if (nums[i] != nums[k - 1]) {
                    nums[k] = nums[i];
                    duplicateTail = nums[k] == nums[k - 1];
                    k++;
                }
            } else {
                nums[k] = nums[i];
                duplicateTail = nums[k] == nums[k - 1];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {};
        int count = solution(arr);
        System.out.println(count + ", " + Arrays.toString(arr));
    }
}
