package NO_0092_Reverse_Linked_List_II;

/**
 * 0092. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * <p>
 * 头插法，一次遍历
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1, head);
        
        // 定位子区间的前驱节点 pre 和区间起点 leftNode
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;
        
        // 循环头插，将 leftNode.next 拆出来拼到 pre.next 位置
        for (int i = 0; i < right - left; i++) {
            // 拆出 leftNode 下一个节点
            ListNode node = leftNode.next;
            leftNode.next = leftNode.next.next;
            // 拼到 pre 下一个节点
            node.next = pre.next;
            pre.next = node;
        }

        return dummyHead.next;
    }
}