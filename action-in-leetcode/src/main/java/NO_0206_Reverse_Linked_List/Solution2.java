package NO_0206_Reverse_Linked_List;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 递归法
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);  // newHead 始终是原链表的尾节点
        head.next.next = head;  // 将下一节点的 next 指向自己，形成环
        head.next = null;       // 保留反转后的指向，取消原指向，解开环
        return newHead;         // 返回原链表的尾节点
    }
}