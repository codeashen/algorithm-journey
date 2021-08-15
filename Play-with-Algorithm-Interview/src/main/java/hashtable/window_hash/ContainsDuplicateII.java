package hashtable.window_hash;

import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 */
public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);

        int l = 0, r = 1;
        while (r < nums.length) {
            if (set.contains(nums[r])) {
                return true;
            }

            set.add(nums[r]);
            r++;

            if (r - l > k) {
                set.remove(nums[l]);
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));  // true
        // System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));  // true
        // System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));  // false
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 1, 2, 3}, 0));  // false
    }
}
