package map_set;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class ValidAnagram {
    /**
     * 哈希表统计频次
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> recordMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            recordMap.put(s.charAt(i), recordMap.containsKey(s.charAt(i)) ? recordMap.get(s.charAt(i)) + 1 : 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!recordMap.containsKey(t.charAt(i)) || recordMap.get(t.charAt(i)) == 0) {
                return false;
            } else {
                recordMap.put(t.charAt(i), recordMap.get(t.charAt(i)) - 1);
            } 
        }

        return true;
    }

    /**
     * 数组统计频次
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
            record[t.charAt(i) - 'a']--;
        }
        
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序后对比
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram3("anagram", "nagaram"));  // true
        System.out.println(isAnagram3("rat", "cat"));  // false
    }
}
