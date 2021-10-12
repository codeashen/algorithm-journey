package NO_0017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

/**
 * 0017. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 回溯法
 * 时间复杂度: O(3^m × 4^n)，其中 m 是输入中对应 3 个字母的数字个数，n 是输入中对应 4 个字母的数字个数
 * 空间复杂度: O(m + n)
 */
class Solution {
    // 每个数字对应的字母，0 和 1 在本题中不用
    private final String[] letterMap = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    private List<String> res;  // 存放结果

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.equals("")) return res;
        findCombination(digits, 0, "");
        return res;
    }

    /**
     * 翻译 digits[k] 可以表示的字符，拼接到字符串 s 上，然后添加到结果 res 中
     *
     * @param digits 数字字符串
     * @param k      将要翻译的索引
     * @param str    到目前位置翻译的结果，当翻译到 digits 最后一位时将其添加到 res 中
     */
    private void findCombination(String digits, int k, String str) {
        // 递归结束条件，digits 翻译完了，直接存入结果集
        if (k == digits.length()) {
            res.add(str);
            return;
        }
        // 查询当前数字可以表示哪些字符
        String letters = letterMap[digits.charAt(k) - '0'];
        // 对每一种情况，继续递归翻译拼接
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, k + 1, str + letters.charAt(i));  // 这里隐藏了回溯过程
        }
    }
}