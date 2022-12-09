package linkedlist;

import linkedlist.node.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        // 删除链表开头所有符合条件的节点
        while (head != null && head.val == val)
            head = head.next;

        if (head == null) return head;

        // 开始逐个考察节点，删除中间的节点
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;  // 跨过待删除节点
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        // 设置虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 开始逐个考察节点，删除中间的节点
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;  // 跨过待删除节点
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        ListNode head1 = new ListNode(1, 2, 6, 3, 4, 5, 6);
        System.out.println(solution.removeElements2(head1, 6));

        ListNode head2 = new ListNode(7, 7, 7, 7);
        System.out.println(solution.removeElements2(head2, 7));
    }
}
