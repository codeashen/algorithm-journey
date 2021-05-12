package graph.minspantree;

/**
 * 稀疏带权图
 */
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
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
