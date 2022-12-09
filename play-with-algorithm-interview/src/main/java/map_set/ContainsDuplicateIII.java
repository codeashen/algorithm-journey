package map_set;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicateIII {

    /**
     * 滑动窗口 + TreeSet
     * @param nums 元素数组
     * @param k    索引 delta
     * @param t    元素 delta
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();  // 有序查找表，存放滑动窗口内元素
        for (int i = 0; i < nums.length; i++) {
            // 查找表中搜索大于等于 nums[i] - t 的元素
            Long ceiling = treeSet.ceiling((long) nums[i] - (long) t);
            // 如果元素存在且小于等于 nums[i] + t，则存在元素落在 [nums[i]-t, nums[i]+t] 区间内，返回 true
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }

            treeSet.add((long) nums[i]);  // 没有找到符合的元素，将此元素放入查找表
            if (treeSet.size() > k) {     // 控制窗口大小
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII solution = new ContainsDuplicateIII();

        int[] nums1 = new int[]{1, 2, 3, 1};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums1, 3, 0));  // true

        int[] nums2 = new int[]{1, 0, 1, 1};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums2, 1, 2));  // true

        int[] nums3 = new int[]{1, 5, 9, 1, 5, 9};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums3, 2, 3));  // false
    }
}
