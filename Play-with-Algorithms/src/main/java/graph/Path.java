package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 深度优先遍历，记录图中从起点 s 可达的所有路径
 */
public class Path {

    private Graph graph;        // 图的引用
    private int s;              // 起始点
    private boolean[] visited;  // 记录dfs的过程中顶点是否被访问
    private int[] from;         // 记录路径，from[i] 表示查找路径上 i 的上一个顶点

    /**
     * 构造方法，深度优先遍历记录图中各顶点遍历路径
     *
     * @param graph 图
     * @param s     遍历起始顶点
     */
    public Path(Graph graph, int s) {
        // 算法初始化
        this.graph = graph;
        assert s >= 0 && s < graph.V();

        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;

        // 寻路算法，只遍历 s 一个顶点
        dfs(s);
    }

    /**
     * 图的深度优先遍历
     *
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        for (Integer node : graph.adj(v)) {
            if (!visited[node]) {
                from[node] = v;
                dfs(node);
            }
        }
    }

    /**
     * 查询从起始点 s 到顶点 w 是否有路径
     *
     * @param w
     * @return
     */
    public boolean hasPath(int w) {
        assert w >= 0 && w < graph.V();
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
}
