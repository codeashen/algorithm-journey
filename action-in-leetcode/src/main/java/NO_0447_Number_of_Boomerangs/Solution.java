package NO_0447_Number_of_Boomerangs;

import java.util.HashMap;
import java.util.Map;

/**
 * 0447. 回旋镖的数量
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 * <p>
 * 哈希表
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)，虽然开了 n 个 map，但是每次遍历完，map 空间就释放了
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            // disFreqMap 中存储点 i 到所有其他点的距离出现的频次
            Map<Integer, Integer> disFreqMap = new HashMap<>();  // 距离-频次 映射
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dis = dis(points[i], points[j]);
                    disFreqMap.put(dis, disFreqMap.getOrDefault(dis, 0) + 1);
                }
            }

            // 遍历 disFreqMap 找到频次大于 2 的距离，计算可以得到回旋镖的个数
            for (Integer count : disFreqMap.values()) {
                res += count * (count - 1);   // 只出现一次也没关系，第二个乘数为 0
            }
        }

        return res;
    }

    // 计算两个点的距离，用平方表示，不开根号
    private int dis(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) +
                (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}