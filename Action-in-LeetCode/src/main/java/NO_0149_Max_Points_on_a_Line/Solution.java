package NO_0149_Max_Points_on_a_Line;

import java.util.HashMap;

/**
 * 0149. 直线上最多的点数
 * https://leetcode-cn.com/problems/max-points-on-a-line/
 * <p>
 * 哈希表统计斜率-频次
 */
class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();  // 斜率-频次 map
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                String slope = getSlope(points[i], points[j]);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            for (Integer value : map.values()) {
                res = Math.max(res, value + 1);  // 要包含 i 点本身，故 +1
            }
        }
        return res;
    }

    // 求点 p、q 两点的斜率
    private String getSlope(int[] p, int[] q) {
        int x = p[0] - q[0];
        int y = p[1] - q[1];
        if (x == 0) {
            return "0,1";
        } else if (y == 0) {
            return "1,0";
        } else {
            if (y < 0) {  // 分子固定正数
                x = -x;
                y = -y;
            }
            int gcdXY = gcd(Math.abs(x), Math.abs(y));
            x /= gcdXY;
            y /= gcdXY;
            return x + "," + y;
        }
    }

    // 求最大公约数
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {
                {1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}
                // {1,1],[3,2],[5,3],[4,1],[2,3],[1,4]
        };
        System.out.println(solution.maxPoints(points));
    }

}