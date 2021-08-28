package dynamic_programming.partition_equal_subset_sum;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * <p>
 * 记忆化搜索
 * 时间复杂度: O(len(nums) * O(sum(nums)))
 * 空间复杂度: O(len(nums) * O(sum(nums)))
 */
public class PartitionEqualSubsetSum1 {

    // memo[i][c] 表示使用索引为 [0...i] 的这些元素,是否可以完全填充一个容量为 c 的背包
    // -1 表示为未计算; 0 表示不可以填充; 1 表示可以填充
    private int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        // 总和为奇数，一定不能分割出等和子集
        if (sum % 2 == 1) {
            return false;
        }
        // 全部填充为未计算
        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    /**
     * 使用 nums[0...index], 是否可以完全填充一个容量为 sum 的背包
     */
    private boolean tryPartition(int[] nums, int index, int sum) {
        if (index < 0 || sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        // 如果计算过，直接返回
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        // 递归计算是否满足
        boolean flag = tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index]);
        memo[index][sum] = flag ? 1 : 0;  // 记忆化
        return memo[index][sum] == 1;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        System.out.println((new PartitionEqualSubsetSum1()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        System.out.println((new PartitionEqualSubsetSum1()).canPartition(nums2));
    }
}
