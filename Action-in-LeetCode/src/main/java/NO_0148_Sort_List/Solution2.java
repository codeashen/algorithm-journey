package NO_0148_Sort_List;

/**
 * 0148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 * <p>
 * 归并排序，自底向上
 * 时间复杂度: O(NlogN)
 * 空间复杂度: O(1)
 */
class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 统计链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(-1, head);
        for (int subLength = 1; subLength < length; subLength *= 2) {
            ListNode pre = dummyHead;       // 前面已经完成归并的尾节点
            ListNode cur = dummyHead.next;  // 待归并部分的首节点
            while (cur != null) {
                // 找到长度为 subLength 的小段 l1
                ListNode l1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++)
                    cur = cur.next;
                
                // 找到长度为 subLength 的小段 l2
                ListNode l2 = cur.next;
                cur.next = null;    // 截断 l1
                cur = l2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++)
                    cur = cur.next;
                
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;  // 截断 l2（如果后面的话）
                }
                cur = next;

                // 归并 l1 和 l2，拼接到 pre 上
                pre.next = merge(l1, l2);
                // 更新 pre
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dummyHead.next;
    }

    // 归并链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 == null)
            tail.next = l2;
        if (l2 == null)
            tail.next = l1;

        return dummyHead.next;
    }
}