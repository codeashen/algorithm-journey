package NO_0131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * <p>
 * 回溯 + 记忆化搜索
 * 时间复杂度: O(n * 2^n)
 * 空间复杂度: O(n^2)
 */
class Solution {
    // memo[l][r] 表示 s[l...r] 是否回文串，0:未计算，1:是，-1:不是
    private int[][] memo;
    // 存放结果
    private List<List<String>> res;
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        memo = new int[s.length()][s.length()];
        dfs(s, 0, new LinkedList<>());
        return res;
    }

    /**
     * 尝试将从 s 的 start 位置开始拼入一个回文串，加入 list
     */
    private void dfs(String s, int start, LinkedList<String> list) {
        // s 遍历完了，存入结果返回
        if (start == s.length()) {
            res.add(new LinkedList<>(list));
            return;
        }
        // 尝试继续加入一个回文串
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end) == 1) {   // 如果是回文串
                list.addLast(s.substring(start, end + 1));  // 拼入
                dfs(s, end + 1, list);  // 递归继续拼入
                list.removeLast();  // 回溯，尝试下一个长度子串
            }
        }
    }

    /**
     * 验证 s[l...r] 是不是回文串
     */
    private int isPalindrome(String s, int l, int r) {
        if (memo[l][r] != 0) return memo[l][r];
        
        if (l >= r) {
            memo[l][r] = 1;
        } else {
            if (s.charAt(l) == s.charAt(r)) {
                memo[l][r] = isPalindrome(s, l + 1, r - 1);
            } else {
                memo[l][r] = -1;
            }
        }
        return memo[l][r];
    }
}