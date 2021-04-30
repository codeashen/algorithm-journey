package unionfind;

/**
 * 基于 size 优化的 并查集
 * <p>
 * unionElements    O(h)
 * isConnected      O(h)
 */
public class UnionFind3 implements UnionFind {

    /**
     * 存放元素的集合编号
     * 其中数组的索引 index 表示元素编号
     * 数组元素 parent[index] 表示对应编号元素的父节点元素编号 index
     */
    private int[] parent;
    /**
     * sz[i] 表示以 i 为根的集合中元素个数
     */
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        // 初始时每一个节点都处于一个独立的集合
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
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
        int pRoot = find(p);
        int qRoot = find(q);
        // 如果根不相同，将元素少的根指向元素多的根
        if (pRoot != qRoot) {
            if (sz[pRoot] < sz[qRoot]) {
                parent[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            } else {
                parent[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
        }
    }

    /**
     * 查找过程，查找元素 p 所对应的集合编号，即根节点编号
     * 时间复杂度 O(h)，h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound!");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
