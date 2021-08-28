package greedy.non_overlapping_intervals;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * <p>
 * 贪心算法
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * <p>
 */
public class NonOverlappingIntervals2 {

    /**
     * 贪心算法求解
     *
     * @param intervals intervals[i][0] 表示第 i 个区间左边界，intervals[i][1] 表示第 i 个区间右边界，二维索引只有 0，1
     * @return 最少移除区间数量，使得剩余区间不重叠
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];   // 按照右边界从小到大排序
            } else {
                return o1[0] - o2[0];   // 右边界相同，按左边界从小到大
            }
        });

        int res = 1;  // 最长不重叠子区间序列数量
        int pre = 0;  // 当前得到最长不重叠子区间序列的末尾区间索引，即 intervals[pre] 是当前序列的最后一个
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][1]) {
                res++;
                pre = i;
            }
        }

        return intervals.length - res;  // 求的是最少移除区间数量
    }


    public static void main(String[] args) {
        NonOverlappingIntervals2 solution = new NonOverlappingIntervals2();

        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println((solution.eraseOverlapIntervals(intervals1)));   // 1

        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println((solution.eraseOverlapIntervals(intervals2)));   // 2

        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println((solution.eraseOverlapIntervals(intervals3)));   // 0
    }
}
