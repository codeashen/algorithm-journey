package recurion_and_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    /**
     * 回溯 + 记忆化搜索
     */
    class Solution {
        // 存放结果
        private List<List<String>> res;
        // memo[i][j] 表示 s[i...j] 是否回文串，0=未计算，1=是，-1=不是
        private int[][] memo;

        public List<List<String>> partition(String s) {
            res = new ArrayList<>();
            memo = new int[s.length()][s.length()];
            dfs(s, 0, new LinkedList<>());
            return res;
        }

        private void dfs(String s, int i, LinkedList<String> path) {
            if (i == s.length()) {  // 如果已经到头了，保存结果返回回溯
                res.add(new LinkedList<>(path));
                return;
            }

            // 尝试加入子串 s[i...j]
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j) == 1) {  // 验证 s[i...j] 是否是回文串
                    path.addLast(s.substring(i, j + 1));
                    dfs(s, j + 1, path);  // 递归
                    path.removeLast();  // 回溯
                }
            }
        }

        // 记忆化搜索 s[i...j] 是否是回文串
        public int isPalindrome(String s, int i, int j) {
            if (memo[i][j] != 0)
                return memo[i][j];

            if (i >= j) {
                memo[i][j] = 1;
            } else if (s.charAt(i) == s.charAt(j)) {
                memo[i][j] = isPalindrome(s, i + 1, j - 1);
            } else {
                memo[i][j] = -1;
            }

            return memo[i][j];
        }
    }

    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(solution.partition("aab"));
    }
}
