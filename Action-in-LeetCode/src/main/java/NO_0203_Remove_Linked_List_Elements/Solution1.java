package NO_0203_Remove_Linked_List_Elements;

/**
 * 0203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * 迭代法
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);

        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.val == val)
                pre.next = pre.next.next;  // 跨过待删除节点
            else
                pre = pre.next;
        }
        return dummyHead.next;
    }
}