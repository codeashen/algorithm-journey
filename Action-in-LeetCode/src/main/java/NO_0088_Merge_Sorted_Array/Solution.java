package NO_0088_Merge_Sorted_Array;

/**
 * 0088. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>
 * 三指针归并
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    /**
     * 将 nums2 归并入 nums1，若从左往右归并会丢失 num1 的左侧待归并元素，
     * nums1 右侧有剩余，应该从右往左归并
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 两待归并部分的右边界指针
        int i = m - 1, j = n - 1;
        
        // 开始从右往左归并
        for (int k = (n + m - 1); k >= 0; k--) {
            // 如果 nums1 归并完了，nums2 依次并入 nums1 即可
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }
            // 如果 nums2 归并完了，nums1 就在对应位置，无需继续归并
            if (j < 0) break;
            
            // 取出两部分较小者并入，并维护索引值
            nums1[k] = nums1[i] > nums2[j] ? 
                    nums1[i--] : nums2[j--];
        }
    }
}