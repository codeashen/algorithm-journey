package NO_0451_Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 0451. 根据字符出现频率排序
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * <p>
 * 频次排序
 * 时间复杂度: O(n + klogk)，其中 n 是字符串 s 的长度，k 是字符串 s 包含的不同字符的个数
 * 空间复杂度: O(n + k)
 */
class Solution {
    public String frequencySort(String s) {
        // map 记录字母频次
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        // 按照频次排序元素
        ArrayList<Character> list = new ArrayList<>(freqMap.keySet());
        Collections.sort(list, (o1, o2) -> freqMap.get(o2) - freqMap.get(o1));

        // 取出元素填到字符数组中
        char[] chars = new char[s.length()];
        int index = 0;
        for (Character character : list) {
            for (int i = 0; i < freqMap.get(character); i++) {
                chars[index++] = character;
            }
        }

        return new String(chars);
    }
}