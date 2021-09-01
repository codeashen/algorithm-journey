package stack_queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    /**
     * 最小堆实现
     * 时间复杂度: O(Nlogk)
     * 空间复杂度: O(N)
     */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // 记录元素频次，k-元素，v-频次
            Map<Integer, Integer> frepMap = new HashMap<>();
            for (int element : nums)
                frepMap.put(element, frepMap.getOrDefault(element, 0) + 1);

            // 优先队列，比较在 frepMap 中的频次，最小堆用 o1-o2, 最大堆用 o2-o1
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> frepMap.get(o1) - frepMap.get(o2));  // 最小堆
            for (Map.Entry<Integer, Integer> entry : frepMap.entrySet()) {
                int element = entry.getKey();  // 元素
                int freq = entry.getValue();   // 频次
                if (queue.size() == k) {
                    // 队列已经有 k 个元素，视情况更新堆顶元素
                    if (freq > frepMap.get(queue.peek())) {
                        queue.poll();
                        queue.offer(element); 
                    }
                } else {
                    // 队列未满 k 个元素，直接加入
                    queue.offer(element);
                }
            }

            int[] res = new int[k];
            for (int i = 0; i < k; i++)
                res[i] = queue.poll();
            return res;
        }
    }


    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();

        int[] nums1 = {1, 1, 1, 2, 2};
        System.out.println(Arrays.toString(solution.topKFrequent(nums1, 2)));  // [1,2]
        int[] nums2 = {1};
        System.out.println(Arrays.toString(solution.topKFrequent(nums2, 1)));  // [1]
    }
}

