package NO_18;

/**
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * <p>
 * 虚拟头节点迭代
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            } else {
                cur = cur.next;
            } 
        }
        return dummyHead.next;
    }
}
