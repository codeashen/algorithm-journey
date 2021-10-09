package NO_0206_Reverse_Linked_List;

/**
 * 0206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 迭代法
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;   // 保存当前遍历的节点
        ListNode pre = null;   // 保存前一个节点
        while (cur != null) {
            ListNode next = cur.next;  // 暂存下一个节点
            cur.next = pre;  // 指针反转
            // 操作完成，pre 和 cur 后移动一位，继续
            pre = cur;
            cur = next;
        }
        return pre;
    }
}