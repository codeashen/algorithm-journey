package NO_0205_Isomorphic_Strings;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 0205. 同构字符串
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * <p>
 * map + set
 */
@Complexity(time = "n", space = "n")
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> wordMap = new HashMap<>();
        Set<Character> valueSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (wordMap.containsKey(key)) {
                if (!wordMap.get(key).equals(value))
                    return false;
            } else {
                if (valueSet.contains(value)) {
                    return false;
                } else {
                    wordMap.put(key, value);
                    valueSet.add(value);
                }
            }
        }

        return true;
    }
}