package array.leetcode.sort;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组  nums1 和 nums2，请你将 nums2 合并到  nums1  中，使 nums1 成为一个有序数组。
 * 初始化  nums1 和 nums2 的元素数量分别为  m 和 n 。你可以假设  nums1 的空间大小等于  m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class MergeSortedArray {

    /**
     * 使用临时数组，记录 nums1 的数据，顺序归并
     */
    public static void solution1(int[] nums1, int m, int[] nums2, int n) {
        // num1 和 nums2 顺序归并起点
        int i = 0, j = 0;
        // 临时数组记录 nums1 的前 m 个元素
        int[] tmpArr = Arrays.copyOfRange(nums1, 0, m);

        for (int k = 0; k < (m + n); k++) {
            if (i >= m) {
                nums1[k] = nums2[j];
                j++;
                continue;
            }
            if (j >= n) {
                nums1[k] = tmpArr[i];
                i++;
                continue;
            }

            if (tmpArr[i] < nums2[j]) {
                nums1[k] = tmpArr[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }

    }

    /**
     * 倒叙归并，不使用临时数组
     */
    public static void solution2(int[] nums1, int m, int[] nums2, int n) {
        // num1 和 nums2 倒叙归并起点
        int i = m - 1, j = n - 1;

        for (int k = (m + n - 1); k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j];
                j--;
                continue;
            }
            if (j < 0) {
                break;
            }

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m = 3, n = 3;
        solution2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
