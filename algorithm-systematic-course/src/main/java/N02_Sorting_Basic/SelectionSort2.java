package N02_Sorting_Basic;

import com.journey.algorithm.common.annotation.Algorithm;
import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.util.ArrayGenerator;
import com.journey.algorithm.common.util.SortingHelper;

@Algorithm(value = "选择排序", feat = "泛型")
@Complexity(time = "n^2")
public class SelectionSort2 {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) < 0)
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
        int n = 1000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortElapse(SelectionSort2.class, arr);
    }
}
