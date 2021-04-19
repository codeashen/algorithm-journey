package linkedlist.leetcode;

/**
 * LeetCode第203题提供的节点类
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 根据数组创建链表，测试用
     *
     * @param arr
     * @return
     */
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Empty array.");
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 返回以本节点为头节点的链表字符串，测试用
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        res.append(cur.val).append("->");
        while (cur.next != null) {
            res.append(cur.next.val).append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}