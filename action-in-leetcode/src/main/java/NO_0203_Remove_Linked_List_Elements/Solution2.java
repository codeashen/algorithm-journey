package NO_0203_Remove_Linked_List_Elements;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 0203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * 递归法
 */
@Complexity(time = "n", space = "n")
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode node = removeElements(head.next, val);
        if (head.val == val)
            head = node;
        else
            head.next = node;

        return head;
    }
}