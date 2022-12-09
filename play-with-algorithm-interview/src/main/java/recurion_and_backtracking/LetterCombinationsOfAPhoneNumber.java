package recurion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    class Solution {
        // 每个数字对应的字母，0 和 1 在本题中不用
        private String[] letterMap = {
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

        // 存放结果
        private List<String> res;

        public List<String> letterCombinations(String digits) {
            res = new ArrayList<>();
            if (digits.equals(""))
                return res;
            findCombination(digits, 0, "");
            return res;
        }

        /**
         * 翻译 digits 字符串 index 索引下的字符，拼接到字符串 s 上，然后添加到结果 res 中
         *
         * @param digits 数字字符串
         * @param index  将要翻译的索引
         * @param str    到目前位置翻译的结果，当翻译到 digits 最后一位时将其添加到 res 中
         */
        private void findCombination(String digits, int index, String str) {
            if (index == digits.length()) {
                res.add(str);
                return;
            }

            String letters = letterMap[digits.charAt(index) - '0'];
            for (int i = 0; i < letters.length(); i++)
                findCombination(digits, index + 1, str + letters.charAt(i));
        }
    }


    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("2"));
    }
}
