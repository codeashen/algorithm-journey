package stack_queue;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int num1, num2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push((stack.pop() + stack.pop()));
                    break;
                case "-":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push((num1 - num2));
                    break;
                case "*":
                    stack.push((stack.pop() * stack.pop()));
                    break;
                case "/":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push((num1 / num2));
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens1));   // 9
        System.out.println(evalRPN(tokens2));   // 6
        System.out.println(evalRPN(tokens3));   // 22
    }
}
