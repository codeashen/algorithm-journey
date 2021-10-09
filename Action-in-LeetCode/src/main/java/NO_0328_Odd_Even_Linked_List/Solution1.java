package NO_0328_Odd_Even_Linked_List;

/**
 * 0328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * <p>
 * 分离节点后合并
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
class Solution1 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        
        ListNode evenHead = head.next;  // 偶链表头节点
        ListNode oddTail = head, evenTail = evenHead;  // 奇、偶链表尾节点
        
        // 遍历链表，一次移动两个节点
        while (evenTail != null && evenTail.next != null) {
            // 更新奇链表尾节点
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            // 更新偶链表尾节点
            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;
        }
        
        oddTail.next = evenHead;  // 拼接奇偶链表
        return head;
    }
}