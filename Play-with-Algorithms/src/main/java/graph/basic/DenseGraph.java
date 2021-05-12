package graph.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图 - 邻接矩阵
 */
public class DenseGraph implements Graph {

    private int n;  // 顶点数
    private int m;  // 边数量
    private boolean directed;   // 是否为有向图
    private boolean[][] g;      // 图的具体数据

    public DenseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;  // 初始化没有任何边
        this.directed = directed;
        // 初始化 n*n 的布尔矩阵，每个 g[i][j] 均为 false，表示所有顶点不向通
        g = new boolean[n][n];
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    /**
     * 向图中添加一条边，从 v 指向 w
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        if (hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    /**
     * 验证图中是否有从 v 到 w 的边, O(1)
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    /**
     * 返回以顶点 v 为起点指向的所有顶点, O(n)
     *
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        List<Integer> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adj.add(i);
            }
        }
        return adj;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((g[i][j] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }
}
