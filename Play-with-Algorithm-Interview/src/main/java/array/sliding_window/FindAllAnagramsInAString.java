package array.sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词: 指字母相同，但排列不同的字符串。
 * <p>
 * 提示：
 *      1 <= s.length, p.length <= 3 * 104
 *      s 和 p 仅包含小写字母
 */
public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        
        int[] targetArr = new int[26];  // 存放字符串 p 的字母情况
        int[] subArr = new int[26];     // 存放字符串 s 子串的字母情况
        for (int i = 0; i < p.length(); i++) {
            // 记录 p 字符情况
            targetArr[p.charAt(i) - 'a']++;
            // 记录 s 第一个子串字母情况，子串长度同 p
            subArr[s.charAt(i) - 'a']++;
        }

        List<Integer> resList = new ArrayList<>();  // 存放符合子串的起始索引
        int l = 0, r = p.length() - 1;  // 固定长度滑动窗口的左右边界
        while (r < s.length()) {
            // 如果子串和 p 元素情况相同，记录下子串索引
            if (isSameArr(targetArr, subArr)) {
                resList.add(l);
            }
            // 判断是否能向右滑动了
            if (r + 1 == s.length()) {
                break;
            }
            // 滑动窗口向右滑动，维护子串元素情况
            subArr[s.charAt(r + 1) - 'a']++;
            subArr[s.charAt(l) - 'a']--;
            l++;
            r++;
        }

        return resList;
    }

    /**
     * 判断两个等长 int 数组各元素是否相同
     */
    private static boolean isSameArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));  // [0,6]
        System.out.println(findAnagrams("abab", "ab"));         // [0,1,2]
        System.out.println(findAnagrams("aa", "bb"));           // []
        System.out.println(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));  // []
    }
}
