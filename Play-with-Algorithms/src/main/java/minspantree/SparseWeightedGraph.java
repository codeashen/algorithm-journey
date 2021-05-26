package minspantree;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏带权图 - 邻接表
 */
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;       // 是否为有向图
    private List<Edge<Weight>>[] g; // 图的具体数据, g[i] 表示顶点 i 出发的所有边

    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0; // 初始没有任何边
        this.directed = directed;
        // g 初始化为 n 个空 List, 表示每一个 g[i] 都为空，既没有任何边
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    /**
     * 返回图中顶点数量
     *
     * @return
     */
    @Override
    public int V() {
        return n;
    }

    /**
     * 返回图中边数量
     *
     * @return
     */
    @Override
    public int E() {
        return m;
    }

    /**
     * 图中添加一条边
     *
     * @param e
     */
    @Override
    public void addEdge(Edge e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;

        g[e.v()].add(new Edge(e));
        if( e.v() != e.w() && !directed ) {
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));
        }
        m ++;
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

        for( int i = 0 ; i < g[v].size() ; i ++ ) {
            if( g[v].get(i).other(v) == w ) {
                return true;
            }
        }
        return false;
    }

    /**
     * 打印展示图
     */
    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                Edge<Weight> e = g[i].get(j);
                System.out.print("(to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
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
        return g[v];
    }
}
