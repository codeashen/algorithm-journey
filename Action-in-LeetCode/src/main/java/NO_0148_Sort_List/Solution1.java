package NO_0148_Sort_List;

/**
 * 0148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 * <p>
 * 归并排序，自顶向下，递归法
 * 时间复杂度: O(NlogN)
 * 空间复杂度: O(logN)
 */
class Solution1 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        // 快慢指针寻找链表中点
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            fast = fast.next;
            if (fast == null || fast.next == null)
                break;
            fast = fast.next;
            slow = slow.next;
        }

        ListNode mid = slow;        // 链表中点，l1 的尾节点
        ListNode head2 = mid.next;  // l2 的头节点
        mid.next = null;            // 断开 l1 和 l2
        // 排序归并两个链表
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        return merge(l1, l2);
    }

    // 归并链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 == null)
            tail.next = l2;
        if (l2 == null)
            tail.next = l1;

        return dummyHead.next;
    }
}