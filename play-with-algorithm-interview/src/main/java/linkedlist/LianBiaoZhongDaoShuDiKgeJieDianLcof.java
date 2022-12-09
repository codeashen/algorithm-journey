package linkedlist;

import linkedlist.node.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {

    /**
     * 虚拟头节点 + 滑动窗口
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            ListNode l = dummyHead;
            ListNode r = dummyHead;
            for (int i = 0; i < k; i++)
                r = r.next;

            while (r != null) {
                l = l.next;
                r = r.next;
            }
            return l;
        }
    }

    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        ListNode head = new ListNode(1, 2, 3, 4, 5);
        System.out.println(solution.getKthFromEnd(head, 2));
    }
}