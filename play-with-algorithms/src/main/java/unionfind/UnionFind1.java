package unionfind;

/**
 * Quick Find 的并查集 数组模拟实现
 *
 * unionElements    O(n)
 * isConnected      O(1)
 */
public class UnionFind1 implements UnionFind {

    /**
     * 存放元素的集合编号
     * 其中数组的索引 index 表示元素编号
     * 数组元素 id[index] 表示对应编号元素所在的集合编号
     */
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        // 初始时每一个节点都处于一个独立的集合
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int size() {
        return id.length;
    }

    /**
     * 判断元素 p, q 是否属于同一个集合
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将 p, q 两元素所在集合合并到同一集合
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        // 将 p 元素所在集合的元素合并到 q 元素所在集合中
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    /**
     * 查询元素 p 对应的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        assert p >= 0 && p < id.length;
        return id[p];
    }
}
