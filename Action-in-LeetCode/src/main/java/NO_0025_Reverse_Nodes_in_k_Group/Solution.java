package NO_0025_Reverse_Nodes_in_k_Group;

/**
 * 0025. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * <p>
 * 遍历，分段
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        
        ListNode pre = dummyHead;
        while (pre.next != null) {
            ListNode segHead = pre.next;    // 分段头
            ListNode segTail = pre;         // 分段尾
            // 判断是否还够一段
            for (int i = 0; i < k; i++) {
                segTail = segTail.next;
                if (segTail == null)        // 如果不够一段，直接返回
                    return dummyHead.next;
            }
            ListNode next = segTail.next;   // 下一段开头
            
            // 断开本段
            pre.next = null;
            segTail.next = null;
            // 反转本段
            this.reverse(segHead);
            // 拼接本段
            pre.next = segTail;
            segHead.next = next;
            // 更新 pre
            pre = segHead;
        }

        return dummyHead.next;
    }
    
    // 反转链表
    private void reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}