package queue.leetcode;

import queue.PriorityQueue;

import java.util.HashMap;

/**
 * LeetCode第347题，前 K 个高频元素
 * 使用自己实现的 基于最大堆的优先队列 实现
 */
public class Solution {

    private class Freq implements Comparable<Freq> {
        int e;      // 元素
        int frep;   // 频次

        public Freq(int e, int frep) {
            this.e = e;
            this.frep = frep;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.frep < another.frep) {
                return 1;
            } else if (this.frep > another.frep) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 统计频次的 map, k=元素，v=频次
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (queue.getSize() < k) {
                queue.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > queue.getFront().frep) {
                queue.dequeue();
                queue.enqueue(new Freq(key, map.get(key)));
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.dequeue().e;
        }
        return res;
    }
}
