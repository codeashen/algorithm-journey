package minspantree;

import java.util.ArrayList;

/**
 * 稠密带权图 - 邻接矩阵
 */
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;   // 是否为有向图
    private Edge<Weight>[][] g; // 图的具体数据，g[i][j] 表示顶点 i 到 j 的边

    /**
     * 构造方法
     *
     * @param n        顶点个数
     * @param directed 是否有向图
     */
    public DenseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0; // 初始没有任何边
        this.directed = directed;
        // g 初始化为 n*n 的矩阵, 每一个 g[i][j] 均为 null, 表示没有任和边
        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    /**
     * 返回顶点数量
     *
     * @return
     */
    @Override
    public int V() {
        return n;
    }

    /**
     * 返回边数量
     *
     * @return
     */
    @Override
    public int E() {
        return m;
    }

    /**
     * 向图中添加一条边
     *
     * @param e
     */
    @Override
    public void addEdge(Edge e) {
        // 验证边 e 的两个顶点在图范围中
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        if (hasEdge(e.v(), e.w())) {
            return;
        }

        // 添加从 v 指向 w 的边
        g[e.v()][e.w()] = new Edge(e);
        // 如果两个顶点不同，且为无向图，还要维护矩阵中从 w 指向 v 的边
        if (e.v() != e.w() && !directed) {
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());
        }
        m++;
    }

    /**
     * 判断图中是否存在从 v 指向 w 的边
     *
     * @param v
     * @param w
     * @return
     */
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w] != null;
    }

    /**
     * 打印展示图
     */
    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {
                    System.out.printf("%-4s\t", g[i][j].wt());
                } else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * 返回图中顶点 v 的所有邻边
     *
     * @param v
     * @return
     */
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        ArrayList<Edge<Weight>> adjv = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i] != null) {
                adjv.add(g[v][i]);
            }
        }
        return adjv;
    }
}
