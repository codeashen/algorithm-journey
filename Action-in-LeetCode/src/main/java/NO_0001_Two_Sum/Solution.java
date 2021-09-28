package NO_0001_Two_Sum;

import java.util.HashMap;

/**
 * 0001. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 哈希表
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 在已经加入 map 的元素中查找 target - nums[i] 的索引
            Integer index = map.getOrDefault(target - nums[i], -1);
            if (index != -1)
                return new int[]{index, i};
            else
                map.put(nums[i], i);
        }
        return new int[]{-1, -1};  // 找不到
    }
}