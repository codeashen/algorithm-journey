package dynamic_programming.partition_equal_subset_sum;

/**
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * <p>
 * 动态规划
 * 时间复杂度: O(len(nums) * O(sum(nums)))
 * 空间复杂度: O(len(nums) * O(sum(nums)))
 */
public class PartitionEqualSubsetSum2 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        // 总和为奇数，一定不能分割出等和子集
        if (sum % 2 == 1) {
            return false;
        }

        int n = nums.length;        // 物品数量
        int capacity = sum / 2;     // 背包容量
        boolean[] memo = new boolean[capacity + 1];  // 记忆数组

        // 首先考虑第 0 号元素是否能将背包填满
        for (int j = 0; j <= capacity; j++) {   // j 表示容量
            memo[j] = (nums[0] == j);
        }

        for (int i = 1; i < n; i++) {   // // 从第 i=1 号物品考虑，范围 [1...n-1]
            for (int j = capacity; j >= nums[i]; j--) {  // 从容量 capacity 反向考虑，范围 [nums(i)...C]，小于 nums(i) 时不用考虑了，因为放不下 i
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[capacity];
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        System.out.println((new PartitionEqualSubsetSum2()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        System.out.println((new PartitionEqualSubsetSum2()).canPartition(nums2));
    }
}
