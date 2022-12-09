package NO_0076_Minimum_Window_Substring;

/**
 * 0076. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] targetArr = new int['z' - 'A' + 1];   // 存放字符串 p 的字母情况
        int[] subArr = new int['z' - 'A' + 1];      // 存放字符串 s 子串的字母情况
        // 记录 t 和 s 的第一个等长子串的情况
        for (int i = 0; i < t.length(); i++) {
            targetArr[t.charAt(i) - 'A']++;
            subArr[s.charAt(i) - 'A']++;
        }

        int l = 0, r = t.length() - 1;              // 窗口边界
        int index = -1, minLen = s.length() + 1;    // 保存最短子串的起始索引和长度
        while (true) {
            if (containAll(subArr, targetArr)) {  // 子串覆盖了目标串
                // 如果当前窗口长度小于最小长度，重新维护 index 和 minLen
                int currentLen = r - l + 1;
                if (currentLen < minLen) {
                    index = l;
                    minLen = currentLen;
                }
                // 尝试取出左侧元素，即左边界右滑
                subArr[s.charAt(l) - 'A']--;
                l++;
            } else {  // 子串覆盖了目标串，不越界的情况下右边界右滑
                if (++r == s.length()) break;
                subArr[s.charAt(r) - 'A']++;
            } 
        }

        return index == -1 ? "" : s.substring(index, index + minLen);
    }

    /**
     * 用于判断子串是否包含目标串所有字符的方法
     */
    private boolean containAll(int[] subArr, int[] targetArr) {
        for (int i = 0; i < targetArr.length; i++) {
            if (subArr[i] < targetArr[i]) return false;
        }
        return true;
    }
}