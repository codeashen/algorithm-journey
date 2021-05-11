package graph;

import java.util.Arrays;

public class Components {

    Graph graph;                // 图的引用
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int count;          // 记录联通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记，即每个节点所属于的连通区域的标记

    public Components(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.nodeCount()];
        Arrays.fill(visited, false);   // 表示所有节点都没遍历过
        Arrays.fill(id, -1);   // 表示所有节点都不连通
        count = 0;

        // 遍历所有节点，求连通分量
        for (int i = 0; i < graph.nodeCount(); i++) {
            if (!visited[i]) {
                // 如果本节点没有被遍历过，执行深度优先遍历，连通分量 +1
                dfs(i);
                count++;
            }
        }
    }

    /**
     * 图的深度优先遍历
     *
     * @param v
     */
    private void dfs(int v) {
        // 先遍历 v
        visited[v] = true;  // 标记已经遍历过了
        id[v] = count;      // 表示节点 v 属于 count 这个连通组里

        // 递归遍历 v 连通的所有节点
        for (Integer node : graph.adj(v)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    /**
     * 返回图 graph 中连通分量个数
     *
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 查询点 v 和点 w 是否连通，即 v 和 w 是否属于一个连通组
     *
     * @param v
     * @param w
     * @return
     */
    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < graph.nodeCount();
        assert w >= 0 && w < graph.nodeCount();
        return id[v] == id[w];
    }
}
