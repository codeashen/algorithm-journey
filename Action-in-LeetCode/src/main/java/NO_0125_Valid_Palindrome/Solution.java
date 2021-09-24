package NO_0125_Valid_Palindrome;

/**
 * 0125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 * <p>
 * 双指针对撞
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;

        while (l < r) {
            // 跳过首尾的无效字符
            while (l < r && !isLetter(s.charAt(l)))
                l++;
            while (r > l && !isLetter(s.charAt(r)))
                r--;

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    // 辅助方法，验证是不是一个有效字符
    private boolean isLetter(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z') || (x >= '0' && x <= '9');
    }
}