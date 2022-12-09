package NO_0082_Remove_Duplicates_from_Sorted_List_II;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0082. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>
 * 一次迭代
 */
@Complexity(time = "n", space = "1")
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1, head);

        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                int x = pre.next.val;  // 重复值
                while (pre.next != null && pre.next.val == x) {
                    pre.next = pre.next.next;  // 删除所有重复值节点
                }
            } else {
                pre = pre.next;
            } 
        }

        return dummyHead.next;
    }
}