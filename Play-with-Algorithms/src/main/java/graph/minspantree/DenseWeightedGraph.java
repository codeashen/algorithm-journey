package graph.minspantree;

/**
 * 稠密带权图
 */
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;   // 是否为有向图
    private Edge<Weight>[][] g; // 图的具体数据，g[i][j] 表示顶点 i 到 j 的边

    public DenseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;

    }

    @Override
    public int V() {
        return 0;
    }

    @Override
    public int E() {
        return 0;
    }

    @Override
    public void addEdge(Edge e) {

    }

    @Override
    public boolean hasEdge(int v, int w) {
        return false;
    }

    @Override
    public void show() {

    }

    @Override
    public Iterable<Edge> adj(int v) {
        return null;
    }
}
