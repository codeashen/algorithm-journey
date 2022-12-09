package map_set;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)  虽然开了 n 个 map，但是每次遍历完，map 空间就释放了
 */
public class NumberOfBoomerangs {

    /**
     * 遍历到点 i 记录距离频次 map，再遍历 map
     * @param points 二维数组，一维索引表示点的个数 n，二维索引只有两个分别表示横纵坐标
     * @return 返回回旋镖数量
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            // disCountMap 中存储点 i 到所有其他点的距离出现的频次
            Map<Integer, Integer> disCountMap = new HashMap<>();  // 距离-频次 映射
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dis = dis(points[i], points[j]);
                    disCountMap.put(dis, disCountMap.getOrDefault(dis, 0) + 1);
                }
            }
            // 遍历 disCountMap 找到频次大于 2 的距离，计算可以得到回旋镖的个数
            for (Integer count : disCountMap.values()) {
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

    public static void main(String[] args) {
        NumberOfBoomerangs solution = new NumberOfBoomerangs();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(solution.numberOfBoomerangs(points));
    }
}
