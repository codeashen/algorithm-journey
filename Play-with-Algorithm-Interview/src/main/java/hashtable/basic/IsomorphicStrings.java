package hashtable.basic;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 提示：
 *   可以假设 s 和 t 长度相同。
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        // s -> t 的字母映射
        HashMap<Character, Character> map = new HashMap<>();
        // 遍历过程中 t 中出现过的字母
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (set.contains(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                    set.add(t.charAt(i));
                }
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        int[] mapArr = new int[128];
        HashSet<Object> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (mapArr[s.charAt(i)] == 0) {
                if (set.contains(t.charAt(i))) {
                    return false;
                } else {
                    mapArr[s.charAt(i)] = t.charAt(i);
                    set.add(t.charAt(i));
                } 
            } else {
                if (mapArr[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            } 
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic2("egg", "add"));     // true
        System.out.println(isIsomorphic2("foo", "bar"));     // false
        System.out.println(isIsomorphic2("paper", "title")); // true
        System.out.println(isIsomorphic2("badc", "baba"));   // false
        System.out.println(isIsomorphic2("13", "42"));       // true
    }
}