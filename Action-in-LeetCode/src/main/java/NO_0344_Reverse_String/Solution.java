package NO_0344_Reverse_String;

/**
 * 0344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 * <p>
 * 双指针对撞
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public void reverseString(char[] s) {
        if (s.length == 0) return;

        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}