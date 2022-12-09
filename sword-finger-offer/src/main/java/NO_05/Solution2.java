package NO_05;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * <p>
 * 使用三倍长度数组
 */
@Complexity(time = "N", space = "N")
class Solution2 {
    public String replaceSpace(String s) {
        int n = s.length();
        if (n == 0) return s;

        char[] chars = new char[3 * n];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else
                chars[size++] = c;
        }

        return new String(chars, 0, size);
    }
}