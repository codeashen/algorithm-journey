package NO_0024_Swap_Nodes_in_Pairs;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0024. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * 递归法
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 每次递归跳过两个节点
        ListNode subList = swapPairs(head.next.next);
        ListNode next = head.next;
        next.next = head;
        head.next = subList;
        return next;
    }
}