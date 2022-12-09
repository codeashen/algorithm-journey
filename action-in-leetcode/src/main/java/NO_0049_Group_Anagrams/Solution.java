package NO_0049_Group_Anagrams;

import java.util.*;

/**
 * 0049. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = generateKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    // 字符排序后新字符串作为 key
    private String generateKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}