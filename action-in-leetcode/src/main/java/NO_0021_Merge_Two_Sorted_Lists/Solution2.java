package NO_0021_Merge_Two_Sorted_Lists;

import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.annotation.LeetCode;

@LeetCode(id = 21, title = "合并两个有序链表",
        solution = "递归法: 两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并")
@Complexity(time = "O(m+n)", space = "O(m+n)")
class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}