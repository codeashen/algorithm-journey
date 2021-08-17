package sort.advance;

/**
 * 双路快速排序法
 * <p>
 * 修改了 partition 方法实现，优化了数组中存在大量重复元素的情况，将等于标的的元素分散到了标的两边，
 * 避免导致大量和标的相等的元素落在标的的一侧，导致递归不平衡的情况
 */
public class QuickSort2 {
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
     * 对数组 arr[l, r] 区间进行partition操作。
     * 返回索引 p, 使得 arr[l, p-1] < arr[p] ; arr[p+1, r] > arr[p]。
     * 即以索引 p 为边界，左边元素小于 arr[p]，右边元素大于 arr[p]
     *
     * @param arr 待进行 partition 操作的数组
     * @param l   操作左区间
     * @param r   操作右区间
     * @return 返回划分左右区间的索引 p
     */
    private static int partition(Comparable[] arr, int l, int r) {
        // 在 arr[l, r] 中随机选择一个值作为分界标的
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];
        int i = l + 1, j = r;

        while (true) {
            // 索引 i 处元素比 v 小时，i 右移
            while (i <= j && arr[i].compareTo(v) < 0) {
                i++;
            }
            // 索引 j 处元素比 v 大时，j 左移
            while (j >= i && arr[j].compareTo(v) > 0) {
                j--;
            }
            // 如果 i < j，元素还没处理完，交换两处元素，两索引各自移动一位，继续循环处理中间剩下的元素
            // 否则表示元素已全部处理完毕，结束循环
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            } else {
                break;
            }
        }
        
        // i 和 j 要么重合要么交叉，所以最后 arr[i] >= v，arr[j] <= v，
        // l 在左侧，应该和小区间其中较小的元素交换
        swap(arr, l, j);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
