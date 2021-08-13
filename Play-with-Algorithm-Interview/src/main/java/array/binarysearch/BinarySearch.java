package array.binarysearch;

import array.ArrayGenUtil;

public class BinarySearch {

    private BinarySearch() {
    }

    /**
     * while 二分搜索
     */
    public static int binarySearch(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target.compareTo(arr[mid]) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归二分搜索
     */
    public static int binarySearch2(Comparable[] arr, int l, int r, Comparable target) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return target.equals(arr[l]) ? l : -1;
        }

        int mid = l + (r - l) / 2;
        if (target.compareTo(arr[mid]) == 0) {
            return mid;
        } else if (target.compareTo(arr[mid]) > 0) {
            return binarySearch2(arr, mid + 1, r, target);
        } else {
            return binarySearch2(arr, l, mid - 1, target);
        }
    }

    public static void main(String[] args) {

        int n = (int) Math.pow(10, 7);
        Integer data[] = ArrayGenUtil.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            if (i != binarySearch(data, i)) {
                throw new IllegalStateException("find i failed!");
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}
