package sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sort.basic.InsertionSort;
import sort.basic.SelectionSort;

import static org.junit.Assert.*;

public class SortTest {

    private Integer[] arr;
    private long sortStartTime;

    @Before
    public void initArr() {
        arr = generateRandomArray(50000, 0, 200);
        // arr = generateNearlyOrderedArray(50000, 20);
        sortStartTime = System.currentTimeMillis();
    }

    @After
    public void printArr() {
        System.out.println("time: " + (System.currentTimeMillis() - sortStartTime) + " ms");
        System.out.println("success: " + isSorted(arr));
        // printArray(arr);
    }

    @Test
    public void selectionSort() {
        SelectionSort.sort1(arr);
        // SelectionSort.sort2(arr);
    }
    
    @Test
    public void insertionSort() {
        // InsertionSort.sort2(arr);
        InsertionSort.sort3(arr);
    }


    //region 辅助方法

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     */
    private Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    /**
     * 生成一个近乎有序的数组
     * 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
     * swapTimes定义了数组的无序程度:
     * swapTimes == 0 时, 数组完全有序；swapTimes 越大, 数组越趋向于无序
     */
    private Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }

        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }

    /**
     * 打印arr数组的所有内容
     */
    private void printArray(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    /**
     * 判断arr数组是否有序
     */
    private boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
    
    //endregion
}
