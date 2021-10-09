package NO_0019_Remove_Nth_Node_From_End_of_List;

/**
 * 0019. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 两次遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        
        // 统计链表长度
        int length = 0;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            pre = pre.next;
            length++;
        }
        
        // 计算正序索引
        int k = length - n;
        pre = dummyHead;
        for (int i = 0; i < k; i++)
            pre = pre.next;
        // 删除元素
        pre.next = pre.next.next;
        
        return head;
    }
}