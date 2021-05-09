package sort.advance;

import java.util.Arrays;

/**
 * 归并排序，自底向上进行归并（Down -> Up）
 * 思路类似于滑块处理
 * O(nlogn)
 */
public class MergeSortBU {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 外层循环 sz 控制归并的区间大小，每轮扩大一倍
        for (int sz = 1; sz < n; sz *= 2) {
            // 内层循环 i 控制归并区间开始的索引位置，类似于滑块，每轮滑动 2 * sz
            for (int i = 0; i < n - sz; i += 2 * sz) {
                // 对 arr 的 [i, i+sz-1] 和 [i+sz, i+2*sz-1] 进行归并
                merge(arr, i, i + sz - 1, Math.min(i + 2 * sz - 1, n - 1));
            }
        }
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
        // 复制带归并区间的副本，存放于 tempArr 不变
        Comparable[] tempArr = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分起始索引l；j指向右半部分起始索引mid+1
        int i = l, j = mid + 1;
        // 依次将比较 tempArr 左右部分的元素，讲较小的填入 arr 的索引 k处
        for (int k = l; k <= r; k++) {
            // 考虑左右两部分其中一部分已经全部处理完的情况
            if (i > mid) {  // 左半部分全部处理完
                arr[k] = tempArr[j - l];  // l是偏移量
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
