package NO_0019_Remove_Nth_Node_From_End_of_List;

import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.annotation.LeetCode;

@LeetCode(id = 19, title = "删除链表的倒数第 N 个结点", solution = "双指针滑动窗口")
@Complexity(time = "n", space = "1")
class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        // 初始化双指针，确定滑动窗口
        ListNode l = dummyHead, r = dummyHead;
        for (int i = 0; i < n; i++)
            r = r.next;
        // 窗口右滑至末尾
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        // 删除节点
        l.next = l.next.next;
        return dummyHead.next;
    }
}