package linkedlist.leetcode;

/**
 * LeetCode第203题 移除链表元素
 * 递归解法
 */
public class Solution3 {

    /**
     * 递归判断节点是否需要被移除，不需要移除就返回本身，需要移除就返回下一个节点
     * 递归将问题转换为小问题：如果链表头节点符合移除条件，就移除，返回新的头节点
     *
     * @param head 待判断是否需要移除的节点
     * @param val  需要移除的元素
     * @return 本节点不需要移除则返回本节点，需要移除则返回下一节点
     */
    public ListNode removeElements(ListNode head, int val) {
        // 考虑问题规模最小的情况（递归退出条件）
        if (head == null) {
            return null;
        }
        
        // 减小问题规模，求子链表移除指定元素发挥的链表
        ListNode res = removeElements(head.next, val);

        // 判断当前节点是否需要移除
        if (head.val == val) {
            // 需要移除，直接返回子链表结果
            return res;
        } else {
            // 不需要移除，拼上子链表结果返回
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{7, 7, 7});
        System.out.println(head);

        ListNode listNode = new Solution3().removeElements(head, 7);
        System.out.println(listNode);
    }

}
