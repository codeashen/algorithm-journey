package minspantree;

import heap.MinHeap;
import unionfind.UnionFind5;

import java.util.ArrayList;
import java.util.List;

/**
 * Kruskal算法求最小生成树
 */
public class KruskalMST<Weight extends Number & Comparable> {

    // 最小生成树所包含的所有边
    private List<Edge<Weight>> mst;
    // 最小生成树的权值
    private Number mstWeight;

    /**
     * 构造函数, 使用Kruskal算法计算graph的最小生成树
     *
     * @param graph
     */
    public KruskalMST(WeightedGraph<Weight> graph) {
        mst = new ArrayList<>();
        
        // 将图中的所有边存放到一个最小堆中（目的是排序）
        MinHeap<Edge<Weight>> pq = new MinHeap<>(graph.E());
        for (int i = 0; i < graph.V(); i++) {
            for (Edge<Weight> edge : graph.adj(i)) {
                if (edge.v() < edge.w()) {  // 避免加两遍
                    pq.add(edge);
                }
            }
        }
        
        // 创建一个并查集，来查看已经访问的节点的连通情况
        UnionFind5 uf = new UnionFind5(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            // 从最小堆中依次从小到大取出所有边
            Edge<Weight> edge = pq.extractMin();
            // 如果该边的两个端点是连通的，说明加入这条边将产生环，舍弃这条边
            if (uf.isConnected(edge.v(), edge.w())) {
                continue;
            }
            
            // 否则将这条加入最小生成树，同时标记该边的两个端点连通
            mst.add(edge);
            uf.unionElements(edge.v(), edge.w());
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
