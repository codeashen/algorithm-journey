package map_set;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 */
public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        
        // 统计每个 pattern 字母代表的单词
        HashMap<Character, String> map = new HashMap<>();
        // 统计已经出现的单词
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // 判断这个 pattern 是否出现过
            if (map.containsKey(pattern.charAt(i))) {
                // 判断 pattern 对应的单词是不是此时遍历到的单词
                if (!arr[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                // 判断单词是否出现过
                if (set.contains(arr[i])) {
                    // 单词出现过但是 map 里没有对应的 patten，表示出现了重复的单词
                    return false;
                } else {
                    map.put(pattern.charAt(i), arr[i]);
                    set.add(arr[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));  // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));  // false
        System.out.println(wordPattern("abba", "dog dog dog dog"));  // false
    }
}
