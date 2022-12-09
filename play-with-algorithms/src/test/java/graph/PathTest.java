package graph;

import org.junit.jupiter.api.Test;

public class PathTest {

    /**
     * 测试深度优先遍历求路径
     */
    @Test
    public void path() {
        String filename = "graph/testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph.graph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g, 0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }

}