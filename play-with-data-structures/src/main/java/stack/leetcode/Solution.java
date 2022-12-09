package stack.leetcode;

import com.journey.algorithm.common.annotation.LeetCode;

import java.util.Stack;

@LeetCode(id = 20, title = "有效的括号")
class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c== '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));
    }
}
