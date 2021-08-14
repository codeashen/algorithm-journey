package array.leetcode.collision_pointer;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoSum2 {

    /**
     * 暴力枚举法
     * 时间复杂度 O(n^2)
     */
    public static int[] solution1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalStateException("The input has no solution");
    }

    /**
     * 线性遍历 + 二分查找
     * 时间复杂度 O(nlogn)
     */
    public static int[] solution2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        throw new IllegalStateException("The input has no solution");
    }

    private static int binarySearch(int[] numbers, int l, int r, int target) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 双端遍历，指针对撞
     * 时间复杂度 O(n)
     */
    public static int[] solution3(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        throw new IllegalStateException("The input has no solution");
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution3(numbers, target)));
    }
}
