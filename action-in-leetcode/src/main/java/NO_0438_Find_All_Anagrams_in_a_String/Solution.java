package NO_0438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

/**
 * 0438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * 滑动窗口
 * 时间复杂度: O(len(s) * len(p))  其中 len(s) 表示窗口滑动，len(p) 表示判断是不是异位词
 * 空间复杂度: O(len(p))  其中开辟两个 len(p) 的数组，对比是不是异位词
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        if (s.length() < p.length()) return resList;

        int[] targetArr = new int[26];  // 存放字符串 p 的字母情况
        int[] subArr = new int[26];     // 存放字符串 s 子串的字母情况
        for (int i = 0; i < p.length(); i++) {
            // 记录 p 字符情况
            targetArr[p.charAt(i) - 'a']++;
            // 记录 s 第一个子串字母情况，子串长度同 p
            subArr[s.charAt(i) - 'a']++;
        }

        // 定义滑动窗口边界，长度固定
        int l = 0, r = p.length() - 1;
        while (true) {
            // 如果子串和 p 元素情况相同，找到了符合的子串
            if (isSameArr(targetArr, subArr)) 
                resList.add(l);
            // 滑倒最右边了结束循环
            if (r + 1 == s.length()) 
                break;

            // 窗口右滑一位，更新窗口内元素情况
            subArr[s.charAt(l) - 'a']--;
            subArr[s.charAt(r + 1) - 'a']++;
            l++;
            r++;
        }

        return resList;
    }

    /**
     * 判断两个等长 int 数组各元素是否相同，本题中判断异位词的方法
     */
    private boolean isSameArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
        