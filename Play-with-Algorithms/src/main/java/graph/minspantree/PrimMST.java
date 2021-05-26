package graph.minspantree;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用优化的Prim算法求图的最小生成树
 */
public class PrimMST<Weight extends Number & Comparable> {

    // 带权图的引用
    private WeightedGraph<Weight> G;
    // 最小索引堆，算法辅助数据结构，其中数据是权值，索引是顶点
    private IndexMinHeap<Weight> ipq;
    // 访问的点所对应的边, 算法辅助数据结构，索引对中索引对应的边
    private Edge<Weight>[] edgeTo;
    // 标记数组，在算法运行过程中标记节点 i 是否被访问
    private boolean[] marked;
    // 存放最小生成树包含的边
    private List<Edge<Weight>> mst;
    // 最小生成树的权值
    private Number mstWeight;

    /**
     * 构造函数, 使用Prim算法求图的最小生成树
     *
     * @param graph
     */
    public PrimMST(WeightedGraph<Weight> graph) {
        G = graph;
        assert G.E() >= 1;
        ipq = new IndexMinHeap<>(G.V());

        // 算法初始化
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        for (int i = 0; i < G.V(); i++) {
            marked[i] = false;
            edgeTo[i] = null;
        }
        mst = new ArrayList<>();

        // Prim
        visit(0);
        while (!ipq.isEmpty()) {
            // 使用最小索引堆找出已经访问的边中权值最小的边
            // 最小索引堆中存储的是点的索引, 通过点的索引找到相对应的边
            int v = ipq.extractMinIndex();
            assert edgeTo[v] != null;
            mst.add(edgeTo[v]);
            visit(v);
        }
    }

    /**
     * 访问节点 v
     *
     * @param v
     */
    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;

        // 将和节点v相连接的未访问的另一端点, 和与之相连接的边, 放入最小堆中
        for (Edge<Weight> edge : G.adj(v)) {
            int w = edge.other(v);
            // 如果边的另一端点未被访问
            if (!marked[w]) {
                // 如果从没有考虑过这个端点, 直接将这个端点和与之相连接的边加入索引堆
                if (edgeTo[w] == null) {
                    edgeTo[w] = edge;
                    ipq.add(w, edge.wt());
                }
                // 如果曾经考虑这个端点, 但现在的边比之前考虑的边更短, 则进行替换
                else if (edge.wt().compareTo(edgeTo[w].wt()) < 0) {
                    edgeTo[w] = edge;
                    ipq.change(w, edge.wt());
                }
            }
        }
    }

    /**
     * 返回最小生成树的边
     *
     * @return
     */
    public List<Edge<Weight>> mstEdges() {
        return mst;
    }

    /**
     * 返回最小生成树权值
     *
     * @return
     */
    public Number result() {
        if (mstWeight == null) {
            // 计算最小生成树权值
            mstWeight = mst.stream().mapToDouble(e -> e.wt().doubleValue()).sum();
        }
        return mstWeight;
    }

}
