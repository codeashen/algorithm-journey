package NO_0021_Merge_Two_Sorted_Lists;

import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.annotation.LeetCode;

@LeetCode(id = 21, title = "合并两个有序链表", solution = "迭代法")
@Complexity(time = "O(m+n)", space = "O(1)")
class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);

        // 归并操作
        ListNode pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        // 将归并完的部分拼上
        pre.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}