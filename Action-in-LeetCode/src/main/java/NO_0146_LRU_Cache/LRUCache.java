package NO_0146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 0146. LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * 使用自定义双向链表
 * 时间复杂度: 对于 put 和 get 都是 O(1)
 * 空间复杂度: O(capacity)
 */
class LRUCache {

    /**
     * 双向链表节点类
     */
    static class Node {
        int key, value;
        Node before, after;
        public Node() {}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // HashMap 用于查找缓存元素
    private Map<Integer, Node> map = new HashMap<>();
    // 本 LRUCache 的容量
    private int capacity;
    // 双向链表的虚拟头尾节点
    private Node head, tail;

    /**
     * 创建 LRUCache，指定容量
     * @param capacity 缓存容量
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 设置虚拟头尾节点
        head = new Node();
        tail = new Node();
        head.after = tail;
        tail.before = head;
    }

    /**
     * 从缓存中获取指定 key 的 value，不存在则返回 -1
     */
    public int get(int key) {
        // 从 map 中获取，如果没有，直接返回 -1
        Node node = map.get(key);
        if (node == null) return -1;

        // 如果存在，将节点移动到尾部
        moveToTail(node);
        return node.value;
    }

    /**
     * 将 key-value 存入缓存中
     */
    public void put(int key, int value) {
        // 创建新节点 newNode，放到链表尾部
        Node newNode = new Node(key, value);
        addTail(newNode);
        // 将 newNode 放入 map 中得到旧节点 oldNode
        Node oldNode = map.put(key, newNode);
        
        if (oldNode == null) {
            // 如果 oldNode 不存在，且容量超了
            if (map.size() > capacity) {
                map.remove(head.after.key);  // 删除链表头节点的缓存
                removeNode(head.after);      // 移除链表头节点
            }
        } else {
            // 如果 oldNode 不存在，删除 oldNode
            removeNode(oldNode);
        } 
    }
    
    // ================= 以下为辅助方法 ======================

    /**
     * 节点移动到双向链表尾部
     */
    private void moveToTail(Node node) {
        node.before.after = node.after;
        node.after.before = node.before;
        addTail(node);
    }

    /**
     * 添加节点到双向链表尾部
     */
    private void addTail(Node node) {
        tail.before.after = node;
        node.before = tail.before;
        tail.before = node;
        node.after = tail;
    }

    /**
     * 删除双向链表中节点
     */
    private void removeNode(Node node) {
        node.before.after = node.after;
        node.after.before = node.before;
        node.before = null;
        node.after = null;
    }
}
