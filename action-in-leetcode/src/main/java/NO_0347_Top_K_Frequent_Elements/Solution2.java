package NO_0347_Top_K_Frequent_Elements;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 0347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * <p>
 * 最小堆
 * 时间复杂度: O(Nlogk)，堆的操作 logk
 * 空间复杂度: O(N)
 */
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个元素出现的次数，key-元素，value-元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums)
            map.put(item, map.getOrDefault(item, 0) + 1);
        // 遍历 map，用最小堆保存频率最大的 k 个元素
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.poll();
                queue.offer(key);
            }
        }
        // 取出最小堆中的元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = queue.poll();
        return res;
    }
}