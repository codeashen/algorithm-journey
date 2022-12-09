package N02_Sorting_Basic;

import com.journey.algorithm.common.annotation.Algorithm;
import com.journey.algorithm.common.annotation.Complexity;

@Algorithm("选择排序")
@Complexity(time = "n^2")
public class SelectionSort1 {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
