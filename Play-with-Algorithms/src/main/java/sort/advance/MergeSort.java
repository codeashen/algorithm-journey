package sort.advance;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 时间复杂度 O(nlogn)，可以在1秒之内轻松处理100万数量级的数据
 */
public class MergeSort {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序，对数组 arr 的 [l, r] 区间范围内的元素进行排序
     *
     * @param arr 待排序数组
     * @param l   排序左区间
     * @param r   排序右区间
     */
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 讲数组 arr 的 [l, mid] 和 [mid+1, r] 两个有序区间进行归并
     *
     * @param arr 待归并数组
     * @param l   归并左端点
     * @param mid 归并中点
     * @param r   归并右端点
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        // 复制待归并区间的副本，存放于 tempArr 不变
        Comparable[] tempArr = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化, i 指向左半部分起始索引 l; j 指向右半部分起始索引 mid+1
        int i = l, j = mid + 1;
        // 依次将比较 tempArr 左右部分的元素，将较小的填入 arr 的索引 k 处
        for (int k = l; k <= r; k++) {
            // 考虑左右两部分其中一部分已经全部处理完的情况
            if (i > mid) {  // 左半部分全部处理完
                arr[k] = tempArr[j - l];  // l 是偏移量
                j++;
                continue;
            } else if (j > r) {  // 右半部分已经全部处理完
                arr[k] = tempArr[i - l];
                i++;
                continue;
            }

            // 左右都没处理完，将左右两部分最小元素中，较小者填入原始数组，然后维护 i 或 j
            if (tempArr[i - l].compareTo(tempArr[j - l]) < 0) {
                arr[k] = tempArr[i - l];
                i++;
            } else {
                arr[k] = tempArr[j - l];
                j++;
            }
        }
    }
}
