package sort.basic;

public class SelectionSort {

    private SelectionSort() {}

    public static void sort(Comparable[] arr) {
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

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
