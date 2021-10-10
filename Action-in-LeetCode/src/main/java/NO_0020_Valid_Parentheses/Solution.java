package NO_0020_Valid_Parentheses;

import java.util.HashMap;
import java.util.Stack;

/**
 * 0020. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 栈
 * 时间复杂度: O(n)
 * 空间复杂度: O(n+∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 6 种括号，∣Σ∣=6
 */
class Solution {
    public boolean isValid(String s) {
        if ((s.length() % 2) != 0) {
            return false;
        }
        
        HashMap<Character, Character> pairs = new HashMap<Character, Character>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (pairs.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(s.charAt(i)))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}