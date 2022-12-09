package linkedlist;

import linkedlist.node.ListNode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    /**
     * 迭代法
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        // 设置虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;  // pre 指向待交换节点的前一个节点
        while (p.next != null && p.next.next != null) {
            // 记录要交换的两个节点和后续节点
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            // 进行交换操作
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            // 更新 pre
            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();

        ListNode head1 = new ListNode(1, 2, 3, 4);
        System.out.println(solution.swapPairs(head1));

        System.out.println(solution.swapPairs(null));

        ListNode head3 = new ListNode(1);
        System.out.println(solution.swapPairs(head3));
    }
}
