package NO_0203_Remove_Linked_List_Elements;

/**
 * 0203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * 递归法
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
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