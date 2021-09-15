package NO_09_Queue_with_Two_Stack;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * <p>
 * 时间复杂度: O(1)
 * 空间复杂度: O(N)
 */
class CQueue {

    private Stack<Integer> appendStack;  // 添加栈
    private Stack<Integer> deleteStack;  // 删除栈

    public CQueue() {
        appendStack = new Stack<>();
        deleteStack = new Stack<>();
    }

    public void appendTail(int value) {
        appendStack.push(value);
    }

    public int deleteHead() {
        // 如果删除栈为空，将添加栈内的元素弹到删除栈中，此时删除栈栈顶元素就是最早加入的元素
        if (deleteStack.isEmpty()) {
            while (!appendStack.isEmpty()) {
                deleteStack.push(appendStack.pop());
            }
        }
        // 返回删除栈栈顶元素，为空则返回 -1
        if (deleteStack.isEmpty()) {
            return -1;
        } else {
            return deleteStack.pop();
        }
    }
}

