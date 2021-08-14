package array.leetcode.sliding_window;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 滑动窗口解法
     * 时间复杂度 O(s.length)
     * 空间复杂度 O(charset.length)
     */
    public static int lengthOfLongestSubstring(String s) {
        byte[] arr = new byte[128]; // ASCII 只有 128 个，用数组表示子串中每一个字符是否已经存在
        int l = 0, r = -1;          // 表示滑块左右边界，即子串在原字符串中的起始位置
        int res = 0;                // 子串长度

        while (l < s.length()) {
            if (r + 1 < s.length() && arr[s.charAt(r + 1)] == 0) {
                // 如果右边还有元素，且元素在子串中没有，加到子串中，右边界右滑
                r++;
                arr[s.charAt(r)] = 1;
            } else {
                // 否则将子串最左边元素剔除，左边界右滑
                arr[s.charAt(l)] = 0;
                l++;
            }
            // 统计子串长度
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));   // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));      // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));     // 3
        System.out.println(lengthOfLongestSubstring(""));           // 0
    }
}