package linkedlist;

import linkedlist.node.ListNode;

/**
 * 237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            node = null;
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
