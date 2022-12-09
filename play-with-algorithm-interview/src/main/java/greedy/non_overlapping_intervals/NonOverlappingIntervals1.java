package greedy.non_overlapping_intervals;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * <p>
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 * <p>
 * 提交到 leetcode 时，执行到第 56 个测试用例超时，https://leetcode-cn.com/submissions/detail/212403317/testcase/
 */
public class NonOverlappingIntervals1 {

    /**
     * 动态规划解法，借鉴最长递增子序列的思路，求出最大不重叠区间数 res，
     * 然后用总区间数 length - res 就是最少移除区间数
     *
     * @param intervals intervals[i][0] 表示第 i 个区间左边界，intervals[i][1] 表示第 i 个区间右边界，二维索引只有 0，1
     * @return 最少移除区间数量，使得剩余区间不重叠
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];   // 按照区间左边界从小到大排序
            } else {
                return o1[1] - o2[1];   // 左边界相同，按右边界从小到大
            }
        });

        // memo[i] 表示以 intervals[i] 结尾的区间能构成的最长不重叠区间序列数
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++) {  // 外层循环考察 0 号区间之后的每个区间
            for (int j = 0; j < i; j++) {  // 内层循环考察 区间 i 之前的所有区间
                if (intervals[i][0] >= intervals[j][1]) {  // 不重叠
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        // 找到最长不重叠区间数
        int res = 0;
        for (int item : memo) {
            res = Math.max(res, item);
        }

        return intervals.length - res;  // 求的是最少移除区间数量
    }


    public static void main(String[] args) {
        NonOverlappingIntervals1 solution = new NonOverlappingIntervals1();

        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println((solution.eraseOverlapIntervals(intervals1)));   // 1

        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println((solution.eraseOverlapIntervals(intervals2)));   // 2

        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println((solution.eraseOverlapIntervals(intervals3)));   // 0
    }
}
