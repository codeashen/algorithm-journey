package linkedlist.leetcode;

/**
 * LeetCode第203题 移除链表元素
 * 基本解法
 */
public class Solution {

    /**
     * 现有一以 head 为头节点的链表，移除其中所有符合元素 val 的节点
     *
     * @param head 链表头节点
     * @param val  要移除的元素
     * @return 返回新的链表头节点
     */
    public ListNode removeElements(ListNode head, int val) {
        // 移除链表开头所有符合的节点
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 如果链表已经空了，操作就完成了
        if (head == null) {
            return head;
        }

        // 通过前驱节点逐一移除之后符合的节点
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{7, 7, 7, 7});
        System.out.println(head);

        ListNode newHead = new Solution().removeElements(head, 7);
        System.out.println(newHead);
    }

}
