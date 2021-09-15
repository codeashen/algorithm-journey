package queue.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * LeetCode第347题，前 K 个高频元素
 * 使用Java的 基于最小堆的优先队列 实现
 */
class Solution2 {

    public int[] topKFrequent(int[] nums, int k) {
        // 统计频次的 map, key=元素，value=频次
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        // 优先级队列，存放元素，传入比较器，比较元素对应的频次
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.remove();
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
