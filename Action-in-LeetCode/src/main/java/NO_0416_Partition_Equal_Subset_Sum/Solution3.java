package NO_0416_Partition_Equal_Subset_Sum;

/**
 * 0416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * <p>
 * 动态规划
 */
class Solution3 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0;    // 总和
        int maxNum = 0; // 最大值
        for (int num : nums) {
            sum += num;          
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) return false;     // 不是 2 的倍数，不能分为两个等和子集
        int target = sum / 2;
        if (maxNum > target) return false;  // 最大值大于总和一半，不能分为两个等和子集

        // memo[i][t] 表示在 nums[0...i] 范围内能否找到和为 t 的子集（包含空集和全集）
        boolean[][] memo = new boolean[n][target + 1];
        // 对于 memo[i][0]，只要取空集即可满足
        for (int i = 0; i < n; i++)
            memo[i][0] = true;
        // 对于 memo[0][t]，只有一个数 nums[0]，只有 memo[0][0] 和 memo[0][nums[0]] 可以满足
        memo[0][nums[0]] = true;
        
        // 对于 memo[i][t]，有子集包含 nums[i] 和不包含 nums[i] 两种情况
        // 不包含: memo[i][t] = memo[i - 1][t]
        // 包含: memo[i][t] = memo[i - 1][t - nums[i]]
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                if (t >= nums[i])
                    memo[i][t] = memo[i - 1][t] || memo[i - 1][t - nums[i]];
                else
                    memo[i][t] = memo[i - 1][t];
            }
        }

        return memo[n - 1][target];
    }
}