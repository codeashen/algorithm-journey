package sort.basic;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 冒泡排序
 */
@Complexity(time = "n^2")
public class BubbleSort {

    public void bubbleSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
