package trie.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 第 677 题，键值映射。
 * 每一个单词对应一个分支，计算以指定前缀开头的所有单词分值总和
 */
public class MapSum {

    private class Node {
        private int value;
        public Map<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new HashMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        cur.value = val;
    }

    /**
     * 计算以 prefix 为前缀的所有单词分值总和
     *
     * @param prefix
     * @return
     */
    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    /**
     * 计算以 node 为根的前缀树下所有节点的分值总和
     *
     * @param node
     * @return
     */
    private int sum(Node node) {
        // 递归结束条件可省略
        // if (node.next.size() == 0) {
        //     return node.value;
        // }

        int res = node.value;
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 5);
        mapSum.insert("application", 10);
        System.out.println("以 \"app\" 开头的所有单词分数总和为: " + mapSum.sum("app"));
    }
}