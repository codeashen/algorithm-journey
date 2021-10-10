package NO_0150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

/**
 * 0150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * <p>
 * 栈
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-(stack.pop() - stack.pop()));
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push((num1 / num2));
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}