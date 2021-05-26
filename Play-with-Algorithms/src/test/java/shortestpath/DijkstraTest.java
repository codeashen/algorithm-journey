package shortestpath;

import minspantree.ReadWeightedGraph;
import minspantree.SparseWeightedGraph;
import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {

    private SparseWeightedGraph<Double> g;

    @Before
    public void init() {
        // 初始化测试图
        String filename = "shortestpath/testG1.txt";
        g = new SparseWeightedGraph<>(5, false);
        ReadWeightedGraph.graph(g, filename);
    }


    /**
     * Dijkstra 算法求最短路径
     */
    @Test
    public void dijkstra() {
        System.out.println("Test Dijkstra:\n");
        Dijkstra<Integer> dij = new Dijkstra<Integer>(g, 0);
        for (int i = 1; i < g.V(); i++) {
            if (dij.hasPathTo(i)) {
                System.out.println("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
                dij.showPath(i);
            } else {
                System.out.println("No Path to " + i);
            }
            System.out.println("----------");
        }
    }
}