package linkedlist;

import linkedlist.node.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 一次遍历
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.next.val == cur.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                } 
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        
        ListNode head1 = new ListNode(1, 1, 2);
        System.out.println(solution.deleteDuplicates(head1));
        
        ListNode head2 = new ListNode(1, 1, 2, 3, 3);
        System.out.println(solution.deleteDuplicates(head2));
    }
}