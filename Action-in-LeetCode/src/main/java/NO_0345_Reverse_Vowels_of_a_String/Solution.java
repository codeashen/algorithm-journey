package NO_0345_Reverse_Vowels_of_a_String;

/**
 * 0345. 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * <p>
 * 双指针对撞
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && isNotVowel(chars[l]))
                l++;
            while (l < r && isNotVowel(chars[r]))
                r--;

            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
        return new String(chars);
    }

    private boolean isNotVowel(char x) {
        return (x != 'a') && (x != 'e') && (x != 'i') && (x != 'o') && (x != 'u')
                && (x != 'A') && (x != 'E') && (x != 'I') && (x != 'O') && (x != 'U');
    }
}