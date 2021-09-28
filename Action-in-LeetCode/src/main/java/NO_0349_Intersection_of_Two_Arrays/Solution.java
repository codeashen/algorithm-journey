package NO_0349_Intersection_of_Two_Arrays;

import java.util.HashSet;

/**
 * 0349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * <p>
 * 哈希集
 * 时间复杂度: O(m+n)
 * 空间复杂度: O(m+n)
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 记录 nums1 中所有元素
        HashSet<Integer> recordSet = new HashSet<>();
        for (int item : nums1) {
            recordSet.add(item);
        }

        // 存放所有交集的 set
        HashSet<Integer> resultSet = new HashSet<>();
        for (int item : nums2) {
            if (recordSet.contains(item)) {
                resultSet.add(item);
            }
        }

        // 返回的是数组，转换一下即可
        int[] arr = new int[resultSet.size()];
        int index = 0;
        for (Integer resultItem : resultSet) {
            arr[index++] = resultItem;
        }
        return arr;
    }
}