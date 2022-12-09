package shortestpath;

import minspantree.Edge;
import minspantree.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Bellman Ford 算法求最短路径
 */
public class BellmanFord<Weight extends Number & Comparable> {

    // 带权图引用
    private WeightedGraph<Weight> G;
    // 路径起始点
    private int s;
    // 存储路径长度，disTo[i] 表示从起点 s 到 i 的最短路径长度
    private Number[] distTo;
    // from[i] 表示最短路径中，到达 i 点的边是那一条，用来恢复整个最短路径
    private Edge<Weight>[] from;
    // 标记图中是否有负权环
    private boolean hasNegativeCycle;

    /**
     * 构造函数, 使用BellmanFord算法求最短路径
     *
     * @param graph 带权图
     * @param s     起点s
     */
    public BellmanFord(WeightedGraph<Weight> graph, int s) {
        G = graph;
        this.s = s;
        distTo = new Number[G.V()];
        from = new Edge[G.V()];
        // 初始化所有节点到 s 都不可达，由 from 数组表示
        for (int i = 0; i < G.V(); i++) {
            from[i] = null;
        }

        // 设置distTo[s] = 0, 并且让from[s]不为NULL, 表示初始s节点可达且距离为0
        distTo[s] = 0.0;
        from[s] = new Edge<>(s, s, (Weight) (Number) (0.0));

        // Bellman-Ford的过程
        // 进行 V-1 次循环, 每一次循环求出从起点到其余所有点, 最多使用 pass 步可到达的最短距离
        for (int pass = 1; pass < G.V(); pass++) {

            // 每次循环中对所有的边进行一遍松弛操作
            // 遍历所有边的方式是先遍历所有的顶点, 然后遍历和所有顶点相邻的所有边
            for (int i = 0; i < G.V(); i++) {
                // 使用我们实现的邻边迭代器遍历和所有顶点相邻的所有边
                for (Edge<Weight> e : G.adj(i)) {
                    // 对于每一个边首先判断 e->v() 可达
                    // 之后看如果 e->w() 以前没有到达过，显然我们可以更新 distTo[e->w()]
                    // 或者 e->w() 以前虽然到达过, 但是通过这个 e 我们可以获得一个更短的距离, 即可以进行一次松弛操作, 我们也可以更新 distTo[e->w()]
                    if (from[e.v()] != null
                            && (from[e.w()] == null || distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue())) {
                        distTo[e.w()] = distTo[e.v()].doubleValue() + e.wt().doubleValue();
                        from[e.w()] = e;
                    }
                }
            }
        }

        hasNegativeCycle = detectNegativeCycle();
    }

    /**
     * 判断图中是否有负权环
     *
     * @return
     */
    private boolean detectNegativeCycle() {
        // 再进行松弛操作，如果还能符合了松弛条件，则存在负权环
        for (int i = 0; i < G.V(); i++) {
            for (Edge<Weight> e : G.adj(i)) {
                if (from[e.v()] != null && distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue())
                    return true;
            }
        }
        return false;
    }

    /**
     * 返回图中是否有负权环
     *
     * @return
     */
    public boolean negativeCycle() {
        return hasNegativeCycle;
    }

    /**
     * 返回从 s 到 w 的最短路径长度
     *
     * @param w
     * @return
     */
    public Number shortestPathTo(int w) {
        assert !hasNegativeCycle;
        assert hasPathTo(w);
        return distTo[w];
    }

    /**
     * 判断从 s 到 w 是否可达
     *
     * @param w
     * @return
     */
    public boolean hasPathTo(int w) {
        assert (w >= 0 && w < G.V());
        return from[w] != null;
    }

    /**
     * 返回从起点 s 到 w 最短路径经过的边
     *
     * @param w
     * @return
     */
    public List<Edge<Weight>> shortestPath(int w) {
        assert !hasNegativeCycle;
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
