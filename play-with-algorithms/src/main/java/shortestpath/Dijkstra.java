package shortestpath;

import heap.IndexMinHeap;
import minspantree.Edge;
import minspantree.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Dijkstra 算法求最短路径
 */
public class Dijkstra<Weight extends Number & Comparable> {

    // 带权图引用
    private WeightedGraph<Weight> G;
    // 路径起始点
    private int s;
    // 存储路径长度，disTo[i] 表示从起点 s 到 i 的最短路径长度
    private Number[] distTo;
    // 标记数组，在算法运行过程中标记节点 i 是否被访问
    private boolean[] marked;
    // from[i] 表示最短路径中，到达 i 点的边是那一条，用来恢复整个最短路径
    private Edge<Weight>[] from;

    /**
     * 构造方法，使用 Dijkstra 算法求最短路径
     *
     * @param graph 带权图
     * @param s     指定的起点
     */
    public Dijkstra(WeightedGraph<Weight> graph, int s) {
        // 算法初始化
        G = graph;
        assert s >= 0 && s < G.V();
        this.s = s;
        distTo = new Number[G.V()];
        marked = new boolean[G.V()];
        from = new Edge[G.V()];
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = 0.0;
            marked[i] = false;
            from[i] = null;
        }

        // 使用索引堆记录当前找到的到达每个顶点的最短距离
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(G.V());

        // 对于起始点 s 进行初始化
        distTo[s] = 0.0;
        from[s] = new Edge<>(s, s, (Weight) (Number) 0.0);
        ipq.add(s, (Weight) distTo[s]);
        marked[s] = true;
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();

            // distTo[v] 就是 s 到 v 的最短距离
            marked[v] = true;

            // 对 v 的所有相邻节点进行更新
            for (Edge<Weight> edge : G.adj(v)) {
                int w = edge.other(v);
                // 如果 s 到 w 的最短距离还没找到
                if (!marked[w]) {
                    // 如果 w 之前没访问过，
                    // 或者访问过，但是通过当前的 v 到 w 的距离更短，则进行更新
                    if (from[w] == null
                            || distTo[v].doubleValue() + edge.wt().doubleValue() < distTo[w].doubleValue()) {
                        distTo[w] = distTo[v].doubleValue() + edge.wt().doubleValue();
                        from[w] = edge;
                        if (ipq.contain(w)) {
                            ipq.change(w, (Weight) distTo[w]);
                        } else {
                            ipq.add(w, (Weight) distTo[w]);
                        }
                    }
                }
            }
        }
    }

    /**
     * 返回从起点 s 到 w 的最短路径长度
     *
     * @param w
     * @return
     */
    public Number shortestPathTo(int w) {
        assert hasPathTo(w);
        return distTo[w];
    }

    /**
     * 判断起点 s 到 w 是否可达
     *
     * @param w
     * @return
     */
    public boolean hasPathTo(int w) {
        assert w >= 0 && w < G.V();
        return marked[w];
    }

    /**
     * 返回从起点 s 到 w 最短路径经过的边
     *
     * @param w
     * @return
     */
    public List<Edge<Weight>> shortestPath(int w) {
        assert hasPathTo(w);

        // 通过 from 数组反查 s 到 w 的路径，放到栈中
        Stack<Edge<Weight>> stack = new Stack<>();
        Edge<Weight> edge = from[w];
        while (edge.v() != this.s) {
            stack.push(edge);
            edge = from[edge.v()];
        }
        stack.push(edge);

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        ArrayList<Edge<Weight>> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    /**
     * 打印从 s 到 w 的最短路径
     *
     * @param w
     */
    public void showPath(int w) {
        List<Edge<Weight>> path = shortestPath(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).v() + " -> ");
            if (i == path.size() - 1) {
                System.out.println(path.get(i).w());
            }
        }
    }
}
