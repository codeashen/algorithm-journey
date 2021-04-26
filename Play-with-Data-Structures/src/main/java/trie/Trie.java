package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树/前缀树基本实现
 */
public class Trie {

    /**
     * 字典树的节点类
     */
    private class Node {
        /**
         * 当前节点是否是一个单词的结尾
         */
        public boolean isWord;
        /**
         * 该节点到下一节点的映射，数量是不定的，用 map 存储
         */
        public Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            next = new HashMap<>();
        }
    }

    /**
     * 字典树的根节点
     */
    private Node root;
    /**
     * 字典树中存储的单词个数
     */
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 查询字典树中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向字典树中添加新单词 word
     *
     * @param word
     */
    public void add(String word) {
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
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询字典树中是否包含指定单词 word
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }

        // 出了循环，如果当前节点的单词结尾，则表示包含本单词
        return cur.isWord;
    }

    /**
     * 查询当前字典树是否包含以 prefix 为前缀的单词
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
