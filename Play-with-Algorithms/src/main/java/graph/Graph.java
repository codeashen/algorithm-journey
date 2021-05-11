package graph;

/**
 * 图接口
 */
public interface Graph {

    /**
     * 返回图中节点数
     *
     * @return
     */
    int nodeCount();

    /**
     * 返回图中边数
     *
     * @return
     */
    int edgeCount();

    /**
     * 添加一条从 v 指向 w 的边
     *
     * @param v
     * @param w
     */
    void addEdge(int v, int w);

    /**
     * 判断是否存在从 v 指向 w 的边
     *
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(int v, int w);

    /**
     * 返回以节点 v 为起点的所有边
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);

    /**
     * 展示图
     */
    void show();

}
