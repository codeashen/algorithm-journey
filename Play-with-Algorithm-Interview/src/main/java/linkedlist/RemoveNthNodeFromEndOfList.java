package linkedlist;

import linkedlist.node.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 虚拟头节点 + 滑动窗口
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 设置虚拟头节点
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            // 设置滑动窗口
            ListNode l = dummyHead;
            ListNode r = dummyHead;
            for (int i = 0; i < n + 1; i++)
                r = r.next;
            // 窗口右滑直到右边界到 null
            while (r != null) {
                l = l.next;
                r = r.next;
            }
            // 跨过待删除节点
            l.next = l.next.next;

            return dummyHead.next;
        }
    }

    /**
     * 计算链表长度
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            // 计算链表长度
            int length = 0;
            for (ListNode cur = dummyHead.next; cur != null; cur = cur.next)
                length++;
            // 计算待删除元素是整数第几个
            int k = length - n;
            ListNode cur = dummyHead;
            for (int i = 0; i < k; i++)
                cur = cur.next;
            // 删除元素
            cur.next = cur.next.next;

            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new RemoveNthNodeFromEndOfList().new Solution2();

        ListNode head1 = new ListNode(1, 2, 3, 4, 5);
        System.out.println(solution.removeNthFromEnd(head1, 2));

        ListNode head2 = new ListNode(1);
        System.out.println(solution.removeNthFromEnd(head2, 1));

        ListNode head3 = new ListNode(1, 2);
        System.out.println(solution.removeNthFromEnd(head3, 1));
    }
}
