package trie.leetcode;

import com.journey.algorithm.common.annotation.LeetCode;

import java.util.HashMap;
import java.util.Map;

@LeetCode(id = 211, title = "添加与搜索单词")
public class WordDictionary {

    private class Node {
        public boolean isWord;
        public Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            next = new HashMap<>();
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        // 逐一添加各字符对应的节点
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 维护单词结尾标记，更新单词数量
        cur.isWord = true;
    }

    /**
     * 搜索字典树中是否包含单词 word，word 中支持通配符 '.' 表示任意字符
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        // 递归结束条件，递归到底
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c != '.') {
            // 不是通配符 '.' 直接匹配字符 
            if (!node.next.containsKey(c)) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            // 是通配符 '.' 循环匹配每一个子节点，只要任一子节点路径匹配成功，返回 true
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            // 所有子节点都没有匹配成功，返回 false
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("apple");
        System.out.println(wd.search("a..le"));
    }
}
