package map_set;

import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 */
public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;

        // 存放滑动窗口内的元素
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i ++) {
            // 如果窗口元素包含当前遍历到的元素，直接返回 true
            if(set.contains(nums[i]))
                return true;

            // 否则将当前元素加到窗口内容
            set.add(nums[i]);
            // 如果窗口元素数量超过 k 个，移除窗口左边界的元素
            if(set.size() == k + 1)
                set.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));  // true
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));  // true
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));  // false
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 1, 2, 3}, 0));  // false
    }
}
