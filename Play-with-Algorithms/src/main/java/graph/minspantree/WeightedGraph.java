package graph.minspantree;

/**
 * 带权图接口
 *
 * @param <Weight> 边Edge的权重Weight
 */
public interface WeightedGraph<Weight extends Number & Comparable> {
    int V();

    int E();

    void addEdge(Edge<Weight> e);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Edge<Weight>> adj(int v);
}
