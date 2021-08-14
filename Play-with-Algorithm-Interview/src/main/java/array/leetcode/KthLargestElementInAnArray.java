package array.leetcode;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class KthLargestElementInAnArray {

    public static int findKthLargest1(int[] nums, int k) {
        return findKthLargest1(nums, 0, nums.length - 1, k);
    }

    private static int findKthLargest1(int[] nums, int l, int r, int k) {
        swap(nums, r, (int) (Math.random() * (r - l + 1) + l));
        int v = nums[r];
        int p = r;

        for (int i = r - 1; i >= l; i--) {
            if (nums[i] < v) {
                swap(nums, i, --p);
            }
        }
        swap(nums, p, r);

        if (p + 1 == k) {
            return nums[p];
        } else if (p + 1 < k) {
            return findKthLargest1(nums, p + 1, r, k);
        } else {
            return findKthLargest1(nums, l, p - 1, k);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest1(nums, 4));  // 4


        int[] nums2 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest1(nums2, 2));  // 5

    }
}
