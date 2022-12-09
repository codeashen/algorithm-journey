package sort.basic;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 选择排序
 */
@Complexity(time = "n^2")
public class SelectionSort {
    /**
     * 左边是有序部分，每一轮寻找无序部分最小的元素，和有序部分尾部后一个元素交换
     */
    public static void sort1(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 寻找 [i, n) 区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 选择排序优化（实际测试甚至更慢 --！）
     * 分两个有序部分，左边小的有序部，右边大的有序部。
     * 每一轮中, 同时找到当前未处理元素的最大值和最小值，分别并入左右两边的有序部分
     */
    public static void sort2(Comparable[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            if (arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                swap(arr, minIndex, maxIndex);
            }

            for (int i = left + 1; i < right; i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                } else if (arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }
            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
