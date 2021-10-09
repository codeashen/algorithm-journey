package NO_0237_Delete_Node_in_a_Linked_List;

/**
 * 0237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * <p>
 * 时间复杂度: O(1)
 * 空间复杂度: O(1)
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            node = null;
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}