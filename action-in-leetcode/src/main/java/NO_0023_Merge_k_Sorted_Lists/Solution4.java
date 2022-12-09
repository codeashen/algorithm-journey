package NO_0023_Merge_k_Sorted_Lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 0023. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * <p>
 * 使用优先级队列
 * 时间复杂度: O(kn * logk), 力扣耗时 6 ms
 * 空间复杂度: O(k)
 */
class Solution4 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) 
                queue.offer(list);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.offer(node.next);
                node.next = null;
            }
            tail.next = node;
            tail = tail.next;
        }

        return dummyHead.next;
    }
}