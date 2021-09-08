package NO_1221_Split_a_String_in_Balanced_Strings;

/**
 * 1221. 分割平衡字符串
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * <p>
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
class Solution {
    public int balancedStringSplit(String s) {
        int d = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                d++;
            } else {
                d--;
            }
            if (d == 0) {
                res++;
            }
        }
        return res;
    }
}
