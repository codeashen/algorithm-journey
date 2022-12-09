package NO_05;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * <p>
 * 使用队列
 */
@Complexity(time = "N", space = "N")
class Solution1 {
    public String replaceSpace(String s) {
        if (s.length() == 0) return s;

        Queue<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                queue.offer('%');
                queue.offer('2');
                queue.offer('0');
            } else
                queue.offer(c);
        }

        chars = new char[queue.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = queue.poll();
        }

        return new String(chars);
    }
}