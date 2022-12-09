package NO_0086_Partition_List;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0086. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * <p>
 * 分组拼接
 */
@Complexity(time = "n", space = "1")
class Solution1 {
    public ListNode partition(ListNode head, int x) {
        // 分成大链表和小链表
        ListNode smallHead = new ListNode(0);   // 小链表头（虚拟）
        ListNode smallTail = smallHead;         // 小链表尾
        ListNode largeHead = new ListNode(0);   // 大链表头（虚拟）
        ListNode largeTail = largeHead;         // 大链表尾

        // 遍历节点，将元素划分到两个链表中
        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }

        // 其 next 指针可能指向一个小于 x 的节点，所以要置空
        largeTail.next = null;
        smallTail.next = largeHead.next;  // 拼接两个链表
        return smallHead.next;
    }
}