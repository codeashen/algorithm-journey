package NO_1221_Split_a_String_in_Balanced_Strings;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 1221. 分割平衡字符串
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * <p>
 */
@Complexity(time = "n", space = "1")
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
