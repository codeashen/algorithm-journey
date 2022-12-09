package NO_0083_Remove_Duplicates_from_Sorted_List;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0083. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * <p>
 * 遍历
 */
@Complexity(time = "n", space = "1")
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            } 
        }
        return head;
    }
}