package NO_0350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 0350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * <p>
 * 哈希表
 * 时间复杂度: O(m+n)
 * 空间复杂度: O(min(m+n))
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 遍历 num1，统计频次
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int item : nums1) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }

        // 遍历 nums2 找出交集
        ArrayList<Integer> list = new ArrayList<>();
        for (int item : nums2) {
            Integer freq = freqMap.getOrDefault(item, 0);
            if (freq > 0) {
                list.add(item);
                freqMap.put(item, freq - 1);
            }
        }

        // 返回数组
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}