package NO_0003_Longest_Substring_Without_Repeating_Characters;

import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.annotation.LeetCode;

@LeetCode(id = 3, title = "无重复字符的最长字串", solution = "滑动窗口")
@Complexity(time = "n", space = "1")
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 定义窗口边界和长度
        int l = 0, r = -1;
        int maxLen = 0;
        // arr[i] == true 表示 (char) i 在窗口里存在，也可以用哈希表
        boolean[] arr = new boolean[128];

        while (l < s.length()) {
            if (r + 1 < s.length() && !arr[s.charAt(r + 1)]) {
                r++;
                arr[s.charAt(r)] = true;
            } else {
                arr[s.charAt(l)] = false;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}