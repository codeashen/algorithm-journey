package minspantree;

import heap.MinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Prim算法求图的最小生成树
 */
public class LazyPrimMST<Weight extends Number & Comparable> {

    // 带权图的引用
    private WeightedGraph<Weight> G;
    // 最小堆，算法辅助数据结构
    private MinHeap<Edge<Weight>> pq;
    // 标记数组，在算法运行过程中标记节点 i 是否被访问
    private boolean[] marked;
    // 存放最小生成树包含的边
    private List<Edge<Weight>> mst;
    // 最小生成树的权值
    private Number mstWeight;

    /**
     * 构造函数，使用Prim算法求图的最小生成树
     *
     * @param graph
     */
    public LazyPrimMST(WeightedGraph<Weight> graph) {
        // 算法初始化
        G = graph;
        pq = new MinHeap<>(G.E());
        marked = new boolean[G.V()];
        mst = new ArrayList<>();

        // Lazy Prim
        visit(0);
        while (!pq.isEmpty()) {
            // 使用最小堆找出已经访问的边中权值最小的边
            Edge<Weight> edge = pq.extractMin();
            // 如果这两条边的两顶点都被访问过了，则扔掉这条边（不是横切边）
            if (marked[edge.v()] && marked[edge.w()]) {
                continue;
            }
            // 否则，这条边则应该存在在最小生成树中
            mst.add(edge);

            // 访问和这条边连接的还没有被访问过的节点
            visit(!marked[edge.v()] ? edge.v() : edge.w());
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

        // 将节点 v 连接的所有未访问的边放到最小堆中
        for (Edge<Weight> edge : G.adj(v)) {
            if (!marked[edge.other(v)]) {  // 另一个顶点没访问过，这条边就没访问过
                pq.add(edge);
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
