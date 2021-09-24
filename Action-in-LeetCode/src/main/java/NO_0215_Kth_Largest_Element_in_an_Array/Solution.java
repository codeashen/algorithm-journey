package NO_0215_Kth_Largest_Element_in_an_Array;

/**
 * 0215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * 快速排序 partition 操作查找
 * 时间复杂度: O(N)
 * 空间复杂度: O(logN)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, k, 0, nums.length - 1);
    }

    /**
     * partition 操作在 nums[l...r] 中查找第 k 大的元素
     * 每次 partition 后比较 k 和标的 pivot 的下标大小，决定下一次 partition 的范围。
     */
    private int partition(int[] nums, int k, int l, int r) {
        // 选取随机标的
        swap(nums, l, (int) (Math.random() * (r - l + 1) + l));
        int pivot = nums[l];

        int p = l;
        // 进行 partition 操作，将大于 pivot 的元素移到 [l, r] 区间左边
        for (int i = l; i <= r; i++) {
            if (nums[i] > pivot)
                swap(nums, i, ++p);
        }
        swap(nums, l, p);

        // 比较 pivot 的索引 p 和 k 的大小
        if (p + 1 == k) {
            // 如果 p+1 == k，那么 nums[p] 就是第 k 大的元素
            return nums[p];
        } else if (p + 1 > k) {
            // 第 k 大的元素在 nums[p] 左边
            return partition(nums, k, l, p - 1);
        } else {
            // 第 k 大的元素在 nums[p] 右边
            return partition(nums, k, p + 1, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}