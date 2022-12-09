package binarysearchtree;

/**
 * 二分查找，在有序数组中查找目标元素的索引，没有返回 -1
 */
public class BinarySearch {

    /**
     * 二分查找，循环写法
     *
     * @param arr
     * @param target
     * @return
     */
    public static int find1(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length - 1;

        // 在 arr[l, r] 区间内查找 target
        while (l <= r) {
            int mid = l + (r - l) / 2;  // 计算中点 mid

            if (target.compareTo(arr[mid]) == 0) {
                return mid;     // 中点位置就是 target，直接返回 mid
            } else if (target.compareTo(arr[mid]) < 0) {
                r = mid - 1;    // target 在 mid 左边，重新计算右端点 r
            } else {
                l = mid + 1;    // target 在 mid 右边，重新计算左端点 l
            }
        }

        return -1;
    }


    /**
     * 二分查找，递归写法
     *
     * @param arr
     * @param target
     * @return
     */
    public static int find2(Comparable[] arr, Comparable target) {
        return recursiveFind(arr, 0, arr.length - 1, target);
    }

    /**
     * 在有序数组 arr 的 [l, r] 区间内递归查找 target
     *
     * @param arr
     * @param l
     * @param r
     * @param target
     * @return
     */
    private static int recursiveFind(Comparable[] arr, int l, int r, Comparable target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (target.compareTo(arr[mid]) == 0) {
            return mid;
        } else if (target.compareTo(arr[mid]) < 0) {
            return recursiveFind(arr, l, mid - 1, target);
        } else {
            return recursiveFind(arr, mid + 1, r, target);
        }
    }
}
