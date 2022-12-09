package NO_0454_4Sum_II;

import java.util.HashMap;
import java.util.Map;

/**
 * 0454. 四数相加 II
 * https://leetcode-cn.com/problems/4sum-ii/
 * <p>
 * 哈希表
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n^2)
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 枚举 nums1 和 nums2 的所有组合，将记录组合加和和频次
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int item1 : nums1) {  // O(n^2)
            for (int item2 : nums2) {
                int sum = item1 + item2;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        // 枚举 nums3 和 nums4 的所有组合，在 sumMap 中找 对应的 key
        for (int item3 : nums3) {  // O(n^2)
            for (int item4 : nums4) {
                res += sumMap.getOrDefault(-(item3 + item4), 0);
            }
        }

        return res;
    }
}