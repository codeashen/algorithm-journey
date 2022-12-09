package linkedlist;

import linkedlist.node.ListNode;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    /**
     * 迭代法
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return pre;
        }
    }

    /**
     * 递归
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);  // newHead 始终是原链表的尾节点
            head.next.next = head;  // 将下一节点的 next 指向自己，形成环
            head.next = null;       // 保留反转后的指向，取消原指向，解开环
            return newHead;         // 返回原链表的尾节点
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        System.out.println(solution.reverseList(new ListNode(1, 2, 3, 4, 5)).toString());
    }
}
