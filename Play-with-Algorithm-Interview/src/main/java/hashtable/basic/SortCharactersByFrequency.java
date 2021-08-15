package hashtable.basic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
public class SortCharactersByFrequency {

    class Node {
        public char c;
        public int freq;

        public Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.containsKey(s.charAt(i)) ? freqMap.get(s.charAt(i)) + 1 : 1);
        }

        PriorityQueue<Map.Entry> queue = new PriorityQueue<>(freqMap.size(), Comparator.comparingInt(o -> - (int) o.getValue()));
        queue.addAll(freqMap.entrySet());

        char[] chars = new char[s.length()];
        int index = 0;
        while (!queue.isEmpty()) {
            Map.Entry entry = queue.poll();
            int freq = (int) entry.getValue();
            for (Integer i = 0; i < freq; i++) {
                chars[index++] = (char) entry.getKey();
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        SortCharactersByFrequency solution = new SortCharactersByFrequency();
        System.out.println(solution.frequencySort("cccaaa"));
        System.out.println(solution.frequencySort("Aabb"));
    }
}
