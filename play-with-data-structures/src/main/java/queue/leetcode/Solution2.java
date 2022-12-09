package queue.leetcode;

import com.journey.algorithm.common.annotation.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 使用 Java 的基于的优先队列（最小堆）{@link PriorityQueue} 实现
 */
@LeetCode(id = 347, title = "前 K 个高频元素")
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
