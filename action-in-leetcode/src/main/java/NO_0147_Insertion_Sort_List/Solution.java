package NO_0147_Insertion_Sort_List;

/**
 * 0147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * <p>
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(1)
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1, head);
        
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val >= lastSorted.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummyHead;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }

        return dummyHead.next;
    }
}