package NO_0092_Reverse_Linked_List_II;

/**
 * 0092. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * <p>
 * 两次遍历，截取拼接法
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1, head);

        // 从虚拟头节点走 left - 1 步，定位到子链表前驱节点
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 从 pre 再走 right - left + 1 步，定位到子链表 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 定位子链表 left 节点和后继节点 succ
        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;
        
        // 截断子链表
        pre.next = null;
        rightNode.next = null;
        // 反转子链表
        reverseList(leftNode);
        // 拼接反转后的子链表
        pre.next = rightNode;
        leftNode.next = succ;

        return dummyHead.next;
    }
    
    // 反转链表
    private void reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}