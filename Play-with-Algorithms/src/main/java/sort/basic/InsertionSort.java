package sort.basic;

/**
 * 插入排序
 * <p>
 * 时间复杂度 O(n^2)
 * 插入排序对近似有序的数组效率很高
 */
public class InsertionSort {
    /**
     * 写法一：无须部分向有序部分交换移动
     */
    public static void sort1(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 索引 i 左边是局部有序状态
            for (int j = i; j > 0; j--) {
                // 将 arr[i] 逐步插入左边局部有序数组的合适位置
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
    public static void sort2(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 索引 i 左边是局部有序状态
            // 将 arr[i] 逐步插入左边局部有序数组的合适位置
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 写法三：有序部分逐步右移，腾出待插入的位置，不涉 swap
     */
    public static void sort3(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable e = arr[i];   // 记录无须部分第一个元素 e
            int index = i;              // 存放 e 应该插入的位置 index
            
            while (index > 0 && arr[index - 1].compareTo(e) > 0) {
                // 将有序部分元素一个个右移，直到找到 e 应该插入的位置
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
