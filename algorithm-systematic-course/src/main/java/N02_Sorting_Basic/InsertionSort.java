package N02_Sorting_Basic;

import com.journey.algorithm.common.annotation.Algorithm;
import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.sort.SortingHelper;

/**
 * 思路：依次把无序部分的元素插入到有序部分的合适位置。
 */
@Algorithm("插入排序")
@Complexity(time = "n^2")
public class InsertionSort {

    /**
     * 写法一：无须部分向有序部分交换移动
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // arr[i] 左边是有序部分
            for (int j = i; j - 1 > 0; j--) {
                // 将 arr[i] 逐步插入有序部分的合适位置
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 写法二：写法一的该编码方式改进
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // arr[i] 左边是有序部分
            // 将 arr[i] 逐步插入有序部分的合适位置
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 写法三：有序部分逐步右移，腾出待插入的位置，不涉 swap
     */
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];    // 记录无序部分第一个元素
            int j;              // 存放 temp 应该插入的位置 j
            for (j = i; j - 1 >= 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                // 将有序部分元素逐个右移，直到找到 temp 应该插入的位置
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     * 写法四：写法三的 while 写法
     */
    public static <E extends Comparable<E>> void sort4(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];    // 记录无序部分第一个元素
            int j = i;          // 存放 temp 应该插入的位置 j
            while (j - 1 >= 0 && arr[j - 1].compareTo(temp) > 0) {
                // 将有序部分元素逐个右移，直到找到 temp 应该插入的位置
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SortingHelper.sortTest(InsertionSort.class, "sort4");
        }
    }
}
