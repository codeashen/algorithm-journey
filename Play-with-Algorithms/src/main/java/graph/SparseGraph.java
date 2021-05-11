package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏图 - 邻接表
 */
public class SparseGraph implements Graph {

    private int n;  // 节点数
    private int m;  // 边数量
    private boolean directed;   // 是否为有向图
    private List<Integer>[] g;  // 图的具体数据

    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        m = 0;  // 初始化没有任何边
        this.directed = directed;
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    public int nodeCount() {
        return n;
    }

    public int edgeCount() {
        return m;
    }

    /**
     * 向图中添加一条边，从 v 指向 w <p>
     * 因为邻接表的 hasEdge 方法时间复杂度为 O(n)，所以不排除平行边的情况
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v != w && !directed) {  // 避免自环边（再调用一次还是会自环）
            g[w].add(v);
        }
        m++;
    }

    /**
     * 验证图中是否有从 v 到 w 的边, O(n)
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v].contains(w);
    }

    /**
     * 返回以节点 v 为起点指向的所有节点, O(1)
     *
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].get(j) + "\t");
            }
            System.out.println();
        }
    }

}
