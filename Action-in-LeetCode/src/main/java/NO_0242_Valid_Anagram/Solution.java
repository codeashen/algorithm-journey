package NO_0242_Valid_Anagram;

/**
 * 0242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * <p>
 * 哈希表记录字母频次
 * 时间复杂度: O(n)
 * 空间复杂度: O(S)  其中 S 为字符集大小，此处 S=26。
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        // 记录 s 和 t 的字母频次关系
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;  // s 中有，对应字母频次 +1
            record[t.charAt(i) - 'a']--;  // t 中有，对用字母频次 -1
        }

        // 对比频次，如果最后每个字母频次都是 0，则为异位词
        for (int i : record) {
            if (i != 0) return false;
        }
        return true;
    }
}