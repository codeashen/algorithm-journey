package NO_18;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * <p>
 * 虚拟头节点迭代
 */
@Complexity(time = "N", space = "1")
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
