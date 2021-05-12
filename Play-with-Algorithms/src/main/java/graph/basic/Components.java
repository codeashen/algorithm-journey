package graph.basic;

/**
 * 使用深度优先遍历，计算图的连通分量，判断连个顶点是否连通
 */
public class Components {

    private Graph G;            // 图的引用
    private boolean[] visited;  // 记录dfs的过程中顶点是否被访问
    private int count;          // 记录联通分量个数
    private int[] id;           // 每个顶点所对应的联通分量标记，即每个顶点所属于的连通组

    /**
     * 构造方法，初始化成员，并进行深度优先遍历，计算出连通分量，区分每个顶点属于哪个连通组
     *
     * @param G
     */
    public Components(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false; // 表示所有顶点都没遍历过
            id[i] = -1;         // 表示所有顶点都不连通
        }
        count = 0;

        // 遍历所有顶点，求连通分量
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                // 如果本顶点没有被遍历过，执行深度优先遍历，连通分量 +1
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
        id[v] = count;      // 表示顶点 v 属于 count 这个连通组里

        // 递归遍历 v 连通的所有顶点
        for (Integer i : G.adj(v)) {
            if (!visited[i]) {
                dfs(i);
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
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }
}
