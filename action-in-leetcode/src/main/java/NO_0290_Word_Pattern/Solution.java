package NO_0290_Word_Pattern;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 0290. 单词规律
 * https://leetcode-cn.com/problems/word-pattern/
 * <p>
 * map + set
 */
@Complexity(time = "n", space = "n")
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (arr.length != pattern.length())
            return false;

        Map<Character, String> wordMap = new HashMap<>();   // 字符对单词的映射 
        Set<String> valueSet = new HashSet<>();   // 记录出现过的单词

        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String value = arr[i];
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