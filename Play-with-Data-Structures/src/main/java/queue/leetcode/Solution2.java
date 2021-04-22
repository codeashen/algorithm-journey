package queue.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * LeetCode第347题，前 K 个高频元素
 * 使用Java的 基于最小堆的优先队列 实现
 */
public class Solution2 {

    private class Freq {
        int e;      // 元素
        int frep;   // 频次

        public Freq(int e, int frep) {
            this.e = e;
            this.frep = frep;
        }
    }

    private class FrepComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.frep - o2.frep;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 统计频次的 map, k=元素，v=频次
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        PriorityQueue<Freq> queue = new PriorityQueue<>(new FrepComparator());
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > queue.peek().frep) {
                queue.remove();
                queue.add(new Freq(key, map.get(key)));
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.remove().e;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        Solution2 solution2 = new Solution2();
        int[] res = solution2.topKFrequent(arr, 2);
        System.out.println(Arrays.toString(res));
    }
}
