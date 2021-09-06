package linkedlist;

import linkedlist.node.ListNode;

import java.util.List;

/**
 * 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {

    /**
     * 分组拼接
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            // 分成大链表和小链表
            ListNode smallHead = new ListNode(0);   // 小链表头（虚拟）
            ListNode smallTail = smallHead;         // 小链表尾
            ListNode largeHead = new ListNode(0);   // 大链表头（虚拟）
            ListNode largeTail = largeHead;         // 大链表尾

            // 遍历节点，将元素划分到两个链表中
            while (head != null) {
                if (head.val < x) {
                    smallTail.next = head;
                    smallTail = smallTail.next;
                } else {
                    largeTail.next = head;
                    largeTail = largeTail.next;
                }
                head = head.next;
            }

            // 其 next 指针可能指向一个小于 x 的节点，所以要置空
            largeTail.next = null;
            smallTail.next = largeHead.next;  // 拼接两个链表
            return smallHead.next;
        }
    }

    /**
     * 快速排序 partition 操作思想
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    class Solution2 {
        public ListNode partition(ListNode head, int x) {
            if (head == null) return head;
            
            // 设置虚拟头节点
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            // 先跳过初始链表前面所有小于 x 的节点，使得 limit 指向左侧小于 x 区间的最后一个节点
            ListNode limit = dummyHead;   // 分界点
            while (limit.next != null && limit.next.val < x)
                limit = limit.next;
            
            // 开始遍历节点，pre 指向待考察节点的前一个节点
            ListNode pre = limit;  
            while (pre.next != null) {
                if (pre.next.val < x) {  // 如果下一个节点小于 x
                    // 移除下一个节点 removeNode
                    ListNode removeNode = pre.next;
                    pre.next = pre.next.next;
                    // 将 removeNode 拼到前面小于 x 区间的后面
                    removeNode.next = limit.next;
                    limit.next = removeNode;
                    // 更新分界点
                    limit = removeNode;
                } else {
                    pre = pre.next;  // 不小于 x 的直接跳过
                }
            }

            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new PartitionList().new Solution2();

        ListNode head1 = new ListNode(1, 4, 3, 2, 5, -1);
        System.out.println(solution.partition(head1, 3));
    }
}
