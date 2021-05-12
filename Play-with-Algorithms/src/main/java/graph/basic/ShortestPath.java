package graph.basic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 广度优先遍历，求图中顶点 s 到各顶点的最短路径
 */
public class ShortestPath {

    private Graph G;            // 图的引用
    private int s;              // 起始顶点
    private boolean[] visited;  // 记录bfs过程中节点是否被访问
    private int[] from;         // 记录路径，from[i] 表示查找路径上 i 的上一个顶点
    private int[] ord;          // 记录到达顶点的路径，ord[i] 表示从起点 s 到 i 经过的边数量

    /**
     * 构造函数, 寻路算法, 寻找图 graph 从 s 点到其他点的路径
     *
     * @param G 图
     * @param s 起始顶点
     */
    public ShortestPath(Graph G, int s) {
        this.G = G;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;

        // 无向图最短路径算法，从 s 开始广度优先遍历整张图
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        ord[s] = 0;
        
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (Integer i : G.adj(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
            }
        }
    }

    /**
     * 查询从起始顶点 s 到 w 是否有路径
     *
     * @param w
     * @return
     */
    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    /**
     * 查询从起点 s 到 w 的路径
     *
     * @param w
     * @return
     */
    public List<Integer> path(int w) {
        if (!hasPath(w)) {
            return Collections.emptyList();
        }

        Stack<Integer> stack = new Stack<>();
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }

        // 从栈中取出元素，获得正序的路径
        List<Integer> path = new ArrayList<>();
        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }
        return path;
    }

    /**
     * 打印出从起点 s 到 w 的路径
     *
     * @param w
     */
    public void showPath(int w) {
        List<Integer> path = path(w);
        String pathStr = path.stream().map(String::valueOf).collect(Collectors.joining(" -> "));
        System.out.println(pathStr);
    }

    /**
     * 返回从起始顶点 s 到 w 的最短路径长度，不可达返回 -1
     *
     * @param w
     * @return
     */
    public int length(int w) {
        assert w >= 0 && w < G.V();
        return ord[w];
    }

}
