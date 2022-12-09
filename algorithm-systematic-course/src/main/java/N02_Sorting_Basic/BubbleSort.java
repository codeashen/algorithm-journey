package N02_Sorting_Basic;

import com.journey.algorithm.common.annotation.Algorithm;
import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.sort.SortingHelper;

/**
 * 思路：依次从无序部分冒泡出最大的元素到有序部分。
 */
@Algorithm("冒泡排序")
@Complexity(time = "n^2")
public class BubbleSort {

    /**
     * 依此从前往后两两比较，把大元素冒泡到数组后面。
     * 循环不变量：数组右侧 i 个最大的有序元素，左侧 [0, n-i] 未冒泡。
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SortingHelper.sortTest(BubbleSort.class);
    }
}
