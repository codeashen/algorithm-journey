package unionfind;

/**
 * 并查集 基本实现
 * <p>
 * unionElements    O(h)
 * isConnected      O(h)
 */
public class UnionFind2 implements UnionFind {

    /**
     * 存放元素的集合编号
     * 其中数组的索引 index 表示元素编号
     * 数组元素 parent[index] 表示对应编号元素的父节点元素编号 index
     */
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        // 初始时每一个节点都处于一个独立的集合
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
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
        // 如果根不相同，将 p 的根指向 q 的根
        if (pRoot != qRoot) {
            parent[pRoot] = qRoot;
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
