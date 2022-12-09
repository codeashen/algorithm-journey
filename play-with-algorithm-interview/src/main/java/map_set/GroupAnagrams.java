package map_set;

import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

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

    private String generateKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private String generateKey2(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                sb.append('a' + i).append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }
}
