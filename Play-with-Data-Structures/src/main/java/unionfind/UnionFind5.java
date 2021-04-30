package unionfind;

/**
 * 基于 路径压缩 优化的 并查集
 * <p>
 * unionElements    O(h)
 * isConnected      O(h)
 */
public class UnionFind5 implements UnionFind {

    /**
     * 存放元素的集合编号
     * 其中数组的索引 index 表示元素编号
     * 数组元素 parent[index] 表示对应编号元素的父节点元素编号 index
     */
    private int[] parent;
    /**
     * rank[i] 表示以 i 为根的集合表示的树的层数
     */
    private int[] rank;

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];
        // 初始时每一个节点都处于一个独立的集合
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        // 如果根不相同，将 rank 低的集合合并到 rank 高的集合上
        if (pRoot != qRoot) {
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
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
            // 增加路径压缩操作
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
