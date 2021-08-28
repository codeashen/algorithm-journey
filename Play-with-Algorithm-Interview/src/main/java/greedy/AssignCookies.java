package greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class AssignCookies {

    /**
     * 先尝试满足最胃口大的孩子
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(1)
     *
     * @param g 胃口值数组
     * @param s 饼干数组
     * @return 返回最多满足孩子数
     */
    public int findContentChildren1(int[] g, int[] s) {
        // 胃口值和饼干大小排序
        Arrays.sort(g);
        Arrays.sort(s);

        // gi、si 分别指向最大胃口值和最大饼干
        int gi = g.length - 1;
        int si = s.length - 1;

        int res = 0;  // 已经满足的孩子数量
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                // 如果饼干可以满足当前孩子，res 加一，继续考察下一个饼干和孩子
                res++;
                gi--;
                si--;
            } else {
                // 如果没法满足，则所有的饼干都没法满足，跳过这个孩子
                gi--;
            }
        }

        return res;
    }

    /**
     * 先尝试满足最胃口小的孩子
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(1)
     *
     * @param g 胃口值数组
     * @param s 饼干数组
     * @return 返回最多满足孩子数
     */
    public int findContentChildren2(int[] g, int[] s) {
        // 胃口值和饼干大小排序
        Arrays.sort(g);
        Arrays.sort(s);

        // gi、si 分别指向最大胃口值和最大饼干
        int gi = 0;
        int si = 0;

        int res = 0;  // 已经满足的孩子数量
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                // 如果饼干可以满足当前孩子，res 加一，继续考察下一个饼干和孩子
                res++;
                gi++;
                si++;
            } else {
                // 如果没法满足，则这块饼干没法满足任何孩子，跳过这块饼干
                si++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int g1[] = {1, 2, 3};
        int s1[] = {1, 1};
        System.out.println((new AssignCookies()).findContentChildren2(g1, s1));

        int g2[] = {1, 2};
        int s2[] = {1, 2, 3};
        System.out.println((new AssignCookies()).findContentChildren2(g2, s2));
    }
}
