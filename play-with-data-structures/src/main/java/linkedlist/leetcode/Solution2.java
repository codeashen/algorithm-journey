package linkedlist.leetcode;

import com.journey.algorithm.common.annotation.LeetCode;

@LeetCode(id = 203, title = "移除链表元素", solution = "虚拟头节点，简化判断")
class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        // 设置虚拟头节点，作为链表头的前驱节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 通过前驱节点逐一移除元素
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        // 注意这里的返回值不是 head
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{17, 73, 7});
        System.out.println(head);

        ListNode listNode = new Solution2().removeElements(head, 7);
        System.out.println(listNode);
    }

}
