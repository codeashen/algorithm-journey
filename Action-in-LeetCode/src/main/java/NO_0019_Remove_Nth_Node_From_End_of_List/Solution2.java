package NO_0019_Remove_Nth_Node_From_End_of_List;

/**
 * 0019. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 双指针滑动窗口
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        // 初始化双指针，确定滑动窗口
        ListNode l = dummyHead, r = dummyHead;
        for (int i = 0; i < n; i++)
            r = r.next;
        // 窗口右滑至末尾
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        // 删除节点
        l.next = l.next.next;
        return dummyHead.next;
    }
}