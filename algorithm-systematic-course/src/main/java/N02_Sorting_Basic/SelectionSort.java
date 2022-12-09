package N02_Sorting_Basic;

import com.journey.algorithm.common.annotation.Algorithm;
import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.sort.SortingHelper;

/**
 * 思路：数组分有序和无序部分，依次从无序部分选择最小的元素放到有序部分。
 */
@Algorithm(value = "选择排序")
@Complexity(time = "n^2")
public class SelectionSort {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SortingHelper.sortTest(SelectionSort.class);
    }
}
