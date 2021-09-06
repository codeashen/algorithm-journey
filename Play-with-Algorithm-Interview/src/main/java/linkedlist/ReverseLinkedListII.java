package linkedlist;

import linkedlist.node.ListNode;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

    /**
     * 两次遍历迭代法，截取拼接
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 因为头节点可能参与反转，设置虚拟头节点可以避免复杂的分类讨论
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            // 从虚拟头节点走 left - 1 步，定位到子链表前驱节点
            ListNode pre = dummyHead;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            // 从 pre 再走 right - left + 1 步，定位到子链表 right 节点
            ListNode rightNode = pre;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }

            // 定位子链表 left 节点和后继节点 succ
            ListNode leftNode = pre.next;
            ListNode succ = rightNode.next;

            // 截断子链表
            pre.next = null;
            rightNode.next = null;

            // 反转子链表
            reverseList(leftNode);

            // 将子链表拼接回去
            pre.next = rightNode;
            leftNode.next = succ;

            return dummyHead.next;
        }

        // 完整反转链表方法，也可以使用递归
        private void reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode nextNode = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextNode;
            }
        }
    }

    /**
     * 头插法
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    class Solution2 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 因为头节点可能参与反转，设置虚拟头节点可以避免复杂的分类讨论
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            // 定位子区间的前驱节点 pre 和区间起点 leftNode
            ListNode pre = dummyHead;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode leftNode = pre.next;

            // 循环将 leftNode 右边的头插到 pre 后面
            for (int i = 0; i < right - left; i++) {
                // 移除后面一个节点，摘出来
                ListNode removeNode = leftNode.next;
                leftNode.next = leftNode.next.next;
                // 将摘出来的节点拼到 pre 后面
                removeNode.next = pre.next;
                pre.next = removeNode;
            }

            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListII().new Solution();
        ListNode head1 = new ListNode(1, 2, 3, 4, 5);
        ListNode head2 = new ListNode(5);

        System.out.println(solution.reverseBetween(head1, 2, 4));
        System.out.println(solution.reverseBetween(head2, 1, 1));
    }
}
