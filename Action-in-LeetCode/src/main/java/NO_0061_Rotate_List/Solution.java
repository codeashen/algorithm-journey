package NO_0061_Rotate_List;

/**
 * 0061. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * <p>
 * 两次遍历，闭合成环再解开
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        // 统计长度
        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        // 计算实际需要移动的步数
        int step = length - k % length;
        if (step == length)
            return head;
        
        // 先成环，cur 指向原 head 前一个节点
        cur.next = head;
        for (int i = 0; i < step; i++)
            cur = cur.next;
        // 解开环
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
}