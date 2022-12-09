package linkedlist;

import linkedlist.node.ListNode;

/**
 * 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

    /**
     * 分离节点后合并
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return head;

            ListNode evenHead = head.next;   // 偶串头节点
            ListNode odd = head, even = evenHead;  // 奇、偶串尾节点

            // 等于一次移动两个节点
            while (even != null && even.next != null) {
                // 更新奇串尾部
                odd.next = even.next;
                odd = odd.next;
                // 更新偶串尾部
                even.next = odd.next;
                even = even.next;
            }

            odd.next = evenHead;  // 拼接奇偶串
            return head;
        }
    }

    /**
     * 遍历，partition
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    class Solution2 {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return head;

            // 分界点，奇区的最后一个节点
            ListNode lastOdd = head;
            // 待考察节点的前驱节点，是一个偶节点，也是已经排好的最后一个偶节点
            ListNode lastEven = head.next;
            
            while (lastEven != null && lastEven.next != null) {
                // 移除下一个节点 removeNode，是一个奇节点
                ListNode odd = lastEven.next;
                lastEven.next = lastEven.next.next;
                // 将 removeNode 拼到前面小于 x 区间的后面
                odd.next = lastOdd.next;
                lastOdd.next = odd;
                // 更新标记点
                lastOdd = odd;
                lastEven = lastEven.next;
            }

            return head;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new OddEvenLinkedList().new Solution2();

        ListNode head1 = new ListNode(1, 2, 3, 4, 5, 6);
        System.out.println(solution.oddEvenList(head1));
    }
}