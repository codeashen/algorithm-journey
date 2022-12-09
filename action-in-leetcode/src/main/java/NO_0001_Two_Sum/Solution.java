package NO_0001_Two_Sum;

import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.annotation.LeetCode;

import java.util.HashMap;

@LeetCode(id = 1, title = "两数之和", tags = "哈希表")
@Complexity(time = "n", space = "n")
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