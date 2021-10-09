package NO_0086_Partition_List;

/**
 * 0086. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * <p>
 * 快速排序 partition 操作思想
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
class Solution2 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        // 设置虚拟头节点
        ListNode dummyHead = new ListNode(-1, head);
        // 跳过链表前所有小于 x 的节点，使得 preX 指向小于 x 的最后一个节点  
        ListNode preX = dummyHead;
        while (preX.next != null && preX.next.val < x)
            preX = preX.next;

        // 遍历节点，头插法移动节点
        ListNode cur = preX;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val < x) {   // 如果下一个节点小于 x
                // 拆出下一个节点拼到 preX 后面
                cur.next = next.next;
                next.next = preX.next;
                preX.next = next;
                // 更新 preX
                preX = next;
            } else {
                cur = next;  // 不小于 x 直接跳过
            }
        }

        return dummyHead.next;
    }
}