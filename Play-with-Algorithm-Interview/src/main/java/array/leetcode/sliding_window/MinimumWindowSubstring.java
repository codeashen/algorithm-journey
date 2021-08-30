package array.leetcode.sliding_window;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] targetArr = new int['z' - 'A' + 1];  // 存放字符串 p 的字母情况
        int[] subArr = new int['z' - 'A' + 1];     // 存放字符串 s 子串的字母情况
        for (int i = 0; i < t.length(); i++) {
            // 记录字符串 t 字符情况
            targetArr[t.charAt(i) - 'A']++;
            // 记录 s 第一个子串字母情况，子串长度同 t
            subArr[s.charAt(i) - 'A']++;
        }

        // 初始化滑动窗口左右边界，初始长度就是 t 的长度
        int l = 0, r = t.length() - 1;
        // 保存子串信息，索引和长度
        int index = -1, length = s.length() + 1;

        while (true) {
            // 判断是不是符合条件的子串
            if (containAll(subArr, targetArr)) {
                // 如果是符合条件的子串并且长度小于现有子串，重新维护子串信息
                if ((r - l + 1) < length) {
                    index = l;
                    length = r - l + 1;
                }
                // 滑动窗口左边界右滑
                subArr[s.charAt(l) - 'A']--;
                l++;
            } else {
                // 不是符合条件子串，不越界的情况下右边界右滑
                if (++r == s.length()) {
                    break;
                }
                subArr[s.charAt(r) - 'A']++;
            }
        }

        return index == -1 ? "" : s.substring(index, index + length);
    }

    private static boolean containAll(int[] subArr, int[] targetArr) {
        for (int i = 0; i < targetArr.length; i++) {
            if (subArr[i] < targetArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));  // "BANC"
        System.out.println(minWindow("a", "a"));    // "a"
        System.out.println(minWindow("a", "aa"));   // ""
    }
}
