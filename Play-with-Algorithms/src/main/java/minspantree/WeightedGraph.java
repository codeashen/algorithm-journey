package minspantree;

/**
 * 带权图接口
 *
 * @param <Weight> 边Edge的权重Weight
 */
public interface WeightedGraph<Weight extends Number & Comparable> {
    /**
     * 返回图中顶点数量
     *
     * @return
     */
    int V();

    /**
     * 返回图中边数量
     *
     * @return
     */
    int E();

    /**
     * 图中添加一条边
     *
     * @param e
     */
    void addEdge(Edge<Weight> e);

    /**
     * 判断图中是否存在从 v 指向 w 的边
     *
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(int v, int w);

    /**
     * 打印展示图
     */
    void show();

    /**
     * 返回图中顶点 v 的所有邻边
     *
     * @param v
     * @return
     */
    Iterable<Edge<Weight>> adj(int v);
}
