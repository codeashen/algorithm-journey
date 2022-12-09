package NO_0146_LRU_Cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 0146. LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * 直接使用 LinkedHashMap
 */
class LinkedHashMapLRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LinkedHashMapLRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}
