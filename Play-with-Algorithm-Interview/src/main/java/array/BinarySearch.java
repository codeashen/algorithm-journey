package array;

/**
 * 704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 */
public class BinarySearch {

    /**
     * while 循环
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     */
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1, mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                } 
            }
            return -1;
        }
    }

    /**
     * 递归
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     */
    class Solution2 {
        public int search(int[] nums, int target) {
            return search(nums, target, 0, nums.length - 1);
        }

        private int search(int[] nums, int target, int l, int r) {
            if (l > r) return -1;
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                return search(nums, target, mid + 1, r);
            } else {
                return search(nums, target, l, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new BinarySearch().new Solution2();

        int n = (int) Math.pow(10, 7);
        int[] data = ArrayGenUtil.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            if (i != solution.search(data, i)) {
                throw new IllegalStateException("find i failed!");
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}