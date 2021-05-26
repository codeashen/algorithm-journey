package shortestpath;

import minspantree.ReadWeightedGraph;
import minspantree.SparseWeightedGraph;
import org.junit.Before;
import org.junit.Test;

public class ShortestPathTest {

    // 没有负权边的图
    private SparseWeightedGraph<Double> g1;
    
    // 有负权边的图
    private SparseWeightedGraph<Double> g2;
    private SparseWeightedGraph<Double> g3;

    @Before
    public void init() {
        // 初始化测试图
        String filename1 = "shortestpath/testG1.txt";
        g1 = new SparseWeightedGraph<>(5, false);
        ReadWeightedGraph.graph(g1, filename1);

        String filename2 = "shortestpath/testG2.txt";
        g2 = new SparseWeightedGraph<>(5, false);
        ReadWeightedGraph.graph(g2, filename2);

        String filename3 = "shortestpath/testG_negative_circle.txt";
        g3 = new SparseWeightedGraph<>(5, false);
        ReadWeightedGraph.graph(g3, filename3);
    }


    /**
     * Dijkstra 算法求最短路径
     */
    @Test
    public void dijkstra() {
        SparseWeightedGraph<Double> testGraph = g1;
        
        System.out.println("Test Dijkstra:\n");
        Dijkstra<Integer> dij = new Dijkstra<Integer>(testGraph, 0);
        for (int i = 1; i < testGraph.V(); i++) {
            if (dij.hasPathTo(i)) {
                System.out.println("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
                dij.showPath(i);
            } else {
                System.out.println("No Path to " + i);
            }
            System.out.println("----------");
        }
    }

    /**
     * BellmanFord 算法求最短路径
     */
    @Test
    public void bellmanFord() {
        SparseWeightedGraph<Double> testGraph = g3;
        System.out.println("Test Bellman-Ford:\n");

        int s = 0;
        BellmanFord<Integer> bellmanFord = new BellmanFord<Integer>(testGraph, s);
        
        if (bellmanFord.negativeCycle()) {
            System.out.println("The graph contain negative cycle!");
        } else {
            for (int i = 0; i < testGraph.V(); i++) {
                if (i == s) {
                    continue;
                }

                if (bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                } else {
                    System.out.println("No Path to " + i);
                }

                System.out.println("----------");
            }
        }

    }
}