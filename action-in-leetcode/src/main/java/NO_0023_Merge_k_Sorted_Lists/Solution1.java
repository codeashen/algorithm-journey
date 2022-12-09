package NO_0023_Merge_k_Sorted_Lists;

import java.util.HashSet;

/**
 * 0023. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * <p>
 * k 个一组对比，暴力解
 * 力扣耗时 1015 ms
 */
class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        HashSet<Integer> finished = new HashSet<>();
        while (finished.size() < k) {
            int index = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null)
                    finished.add(i);
                else if (index == -1 || lists[i].val < lists[index].val)
                    index = i;
            }
            if (index != -1) {
                ListNode node = lists[index];
                lists[index] = node.next;
                node.next = null;
                pre.next = node;
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}