package sort;

import heap.HeapSort;
import heap.HeapSort2;
import org.junit.jupiter.api.Test;
import sort.advance.*;
import sort.basic.InsertionSort;
import sort.basic.SelectionSort;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortTest {

    @Test
    public void sortTest() {
        // 随机数组
        Integer[] randomArr = randomArr(100_0000, 0, 100_0000);
        // 近似有序数组
        Integer[] nearlyOrderedArr = nearlyOrderedArr(100_0000, 100);
        // 大量重复元素数组
        Integer[] duplicateArr = randomArr(100_0000, 0, 300);


        System.out.println("======================= 【选择排序】 =======================");
        sort(SelectionSort.class, "sort1", Arrays.copyOf(randomArr, 1_0000));
        sort(SelectionSort.class, "sort2", Arrays.copyOf(randomArr, 1_0000));


        System.out.println("======================= 【插入排序】 =======================");
        sort(InsertionSort.class, "sort1", Arrays.copyOf(randomArr, 1_0000));
        sort(InsertionSort.class, "sort2", Arrays.copyOf(randomArr, 1_0000));
        sort(InsertionSort.class, "sort3", Arrays.copyOf(randomArr, 1_0000));
        // 插入排序对于近似有序的数组，效率很高
        sort(InsertionSort.class, "sort3", Arrays.copyOf(nearlyOrderedArr, nearlyOrderedArr.length));


        System.out.println("======================= 【归并排序】 =======================");
        sort(MergeSort.class, "sort", Arrays.copyOf(randomArr, 100_0000));
        sort(MergeSortBU.class, "sort", Arrays.copyOf(randomArr, 100_0000));


        System.out.println("======================= 【快速排序】 =======================");
        sort(QuickSort.class, "sort", Arrays.copyOf(randomArr, 100_0000));
        // 对于近似有序的数组，如果不随机选择标的（QuickSort第47行），会导致递归过深，效率很慢甚至直接 StackOverflow
        sort(QuickSort.class, "sort", Arrays.copyOf(nearlyOrderedArr, 100_0000));
        // 对于存在大量重复元素的数组，因存在大量和标的 v 相等的元素，这些元素落在标的的一侧，导致递归树不平衡，很慢甚至 StackOverflow
        sort(QuickSort.class, "sort", Arrays.copyOf(duplicateArr, 100_0000));
        // 双路快速排序，解决大量重复元素问题
        sort(QuickSort2.class, "sort", Arrays.copyOf(duplicateArr, 100_0000));
        // 三路快速排序，解决大量重复元素问题，减少大小两部分元素数量
        sort(QuickSort3.class, "sort", Arrays.copyOf(duplicateArr, 100_0000));


        System.out.println("======================= 【堆排序】 =========================");
        // 借助堆数据结构
        sort(HeapSort2.class, "sort1", Arrays.copyOf(randomArr, 100_0000));
        sort(HeapSort2.class, "sort2", Arrays.copyOf(randomArr, 100_0000));
        // 直接在原数组上进行堆排序
        sort(HeapSort.class, "sort", randomArr(100_0000, 0, 100_0000));
    }

    //region ===================== 辅助测试方法 ==========================

    /**
     * 测试排序方法，统计性能
     *
     * @param sortClass      使用的排序类
     * @param sortMethodName 使用的排序方法名
     * @param arr            待排序数组
     */
    private void sort(Class sortClass, String sortMethodName, Comparable[] arr) {
        try {
            // 反射获取排序方法
            Method sortMethod = sortClass.getMethod(sortMethodName, Comparable[].class);
            long startTime = System.currentTimeMillis();
            // 执行排序操作
            sortMethod.invoke(null, (Object) arr);
            long endTime = System.currentTimeMillis();
            // 判断是否有序
            assertTrue(isSorted(arr));
            // 打印元素个数和排序时间
            System.out.printf("%-18s%-10scount=%-10dtime=%dms\n",
                    sortClass.getSimpleName(), sortMethodName, arr.length, (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     */
    private Integer[] randomArr(int n, int rangeL, int rangeR) {
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
    private Integer[] nearlyOrderedArr(int n, int swapTimes) {
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
