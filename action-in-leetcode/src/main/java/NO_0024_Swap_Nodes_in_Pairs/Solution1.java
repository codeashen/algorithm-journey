package NO_0024_Swap_Nodes_in_Pairs;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0024. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * 迭代法
 */
@Complexity(time = "n", space = "1")
class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);

        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next != null) {
            // 记录 pre 后面三个节点
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            // 交换顺序
            pre.next = node2;
            node2.next = node1;
            node1.next = next;
            // 更新 pre
            pre = node1;
        }

        return dummyHead.next;
    }
}