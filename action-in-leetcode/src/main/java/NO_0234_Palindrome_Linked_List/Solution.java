package NO_0234_Palindrome_Linked_List;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * 寻找链表中点 + 链表后半部逆序 + 对比链表
 */
@Complexity(time = "n", space = "1")
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // 找中点
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        // 反转后半部
        l2 = reverseList(l2);
        // 对比链表
        return compareList(l1, l2);
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

    // 对比两个链表
    private boolean compareList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}