package NO_0445_Add_Two_Numbers_II;

import java.util.Stack;

/**
 * 0445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * <p>
 * 栈
 * 时间复杂度: O(max(m,n))   其中 m 和 n 分别为两个链表的长度
 * 空间复杂度: O(m+n)
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;  // 进位值
        ListNode curNode = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            curNode = new ListNode(cur, curNode);
        }
        return curNode;
    }
}