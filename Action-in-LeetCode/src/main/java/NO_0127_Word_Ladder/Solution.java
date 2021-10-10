package NO_0127_Word_Ladder;

import java.util.*;

/**
 * 0127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 * <p>
 * 深度优先遍历
 * 时间复杂度: O()
 * 空间复杂度: O()
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();   // 队列用于 BFS
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();  // 用于记录已经访问过的节点
        visited.add(beginWord);
        int count = 1;  // BFS 经过的层数
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String preWord = queue.poll();  // 前一层的单词
                // 如果可以转换为 endWord，直接返回
                if (canConvert(preWord, endWord))
                    return count + 1;
                // 遍历 wordList，找到能转换的单词，入队
                for (String item : wordList) {
                    if (visited.contains(item) || !canConvert(preWord, item)) {
                        continue;   // 已经访问过和不能转换的不入队
                    } else {
                        queue.offer(item);
                        visited.add(item);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    // 判断是否能转换
    private boolean canConvert(String str1, String str2) {
        int def = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                def++;
            if (def > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}