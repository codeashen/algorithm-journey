package NO_0002_Add_Two_Numbers;

import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.annotation.LeetCode;

@LeetCode(id = 2, title = "两数相加", solution = "同时迭代法")
@Complexity(time = "O(max(m,n)) 其中 m、n 分别表示 l1、l2 节点数",
        space = "O(1) 官方说返回值不计入空间复杂度")
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;  // 返回链表的头和尾
        int carry = 0;  // 进位值

        while (l1 != null || l2 != null) {
            // 计算当前数位的和 sum
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;  // 加上上一次的进位

            // 创建节点，接到尾部
            ListNode node = new ListNode(sum % 10);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            // 记录进位值
            carry = sum / 10;

            // l1、l2 指向下一个
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 不要忘记考虑最后还有进位的情况
        if (carry > 0)
            tail.next = new ListNode(carry);

        return head;
    }
}