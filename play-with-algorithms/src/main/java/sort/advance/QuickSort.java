package sort.advance;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 快速排序
 */
@Complexity(time = "nlogn")
public class QuickSort {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用快速排序,对数组 arr [l, r] 区间进行排序
     *
     * @param arr 待排序数组
     * @param l   排序左区间
     * @param r   排序右区间
     */
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    /**
     * 对数组 arr[l, r] 区间进行 partition 操作。
     * 返回索引 p, 使得 arr[l, p-1] < arr[p] ; arr[p+1, r] > arr[p]。
     * 即以索引 p 为边界，左边元素小于 arr[p]，右边元素大于 arr[p]
     *
     * @param arr 待进行 partition 操作的数组
     * @param l   操作左区间
     * @param r   操作右区间
     * @return 返回划分左右区间的索引 p
     */
    private static int partition(Comparable[] arr, int l, int r) {
        // Comparable v = arr[l];  // 取第一个元素作为分界标的 v
        /*
         * 优化：防止第一个元素太大或太小，导致划分后左右两部分元素个数相差太大，进而导致递归树嫉妒不平衡，
         * 一侧的递归深度很深，影响效率，极端形况下退化成 n^2 复杂度。
         * 为降低此情况概率，在 arr[l, r] 区间随机选出一个元素和 l 处元素交换，再将 arr[l] 作为标的。
         */
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];
        int p = l;  // 分界索引 p，指向小区间尾部，p+1 就是大区间头部
        
        for (int i = l + 1; i <= r; i++) {
            // 从 l + 1 开始逐个将元素分界，使满足 arr[l+1, p] < v ; arr[p+1, i) > v
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, p + 1);   // 和大区间头部交换
                p++;  // 更新小区间尾部
            }
        }
        
        // 交换 l、p，将 v 放到索引 p 的位置，使满足 arr[l, p-1] < arr[p] ; arr[p+1, r] > arr[p]
        swap(arr, l, p);
        return p;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
