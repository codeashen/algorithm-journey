package NO_0143_Reorder_List;

/**
 * 0143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 * <p>
 * 寻找链表中点 + 链表后半部逆序 + 合并链表
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        // 寻找链表中点
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        // 链表逆序
        l2 = reverseList(l2);
        // 合并链表
        mergeList(l1, l2);
    }

    // 快慢指针寻找链表中点
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 链表反转
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 合并链表
    private void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            // 两个链表的下一链表
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            // 合并连接链表
            l1.next = l2;
            l2.next = next1;
            // 更新 l1、l2
            l1 = next1;
            l2 = next2;
        }
    }
}