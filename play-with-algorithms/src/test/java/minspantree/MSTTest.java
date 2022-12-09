package minspantree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 最小生成树算法测试
 */
public class MSTTest {

    private SparseWeightedGraph<Double> g1;
    private SparseWeightedGraph<Double> g2;
    private SparseWeightedGraph<Double> g3;
    private SparseWeightedGraph<Double> g4;

    @BeforeEach
    public void init() {
        // 初始化测试图
        String filename1 = "minspantree/testG1.txt";
        g1 = new SparseWeightedGraph<>(8, false);
        ReadWeightedGraph.graph(g1, filename1);

        String filename2 = "minspantree/testG2.txt";
        g2 = new SparseWeightedGraph<>(250, false);
        ReadWeightedGraph.graph(g2, filename2);

        String filename3 = "minspantree/testG3.txt";
        g3 = new SparseWeightedGraph<>(1000, false);
        ReadWeightedGraph.graph(g3, filename3);

        String filename4 = "minspantree/testG4.txt";
        g4 = new SparseWeightedGraph<>(10000, false);
        ReadWeightedGraph.graph(g4, filename4);
    }

    /**
     * Lazy Prim 算法求最小生成树
     */
    @Test
    public void lazyPrim() {
        long startTime = System.currentTimeMillis();

        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g4);
        List<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        long endTime = System.currentTimeMillis();
        System.out.println("take time: " + (endTime - startTime) + " ms");
    }

    /**
     * 优化 Prim 算法，求最小生成树
     */
    @Test
    public void prim() {
        long startTime = System.currentTimeMillis();

        System.out.println("Test Prim MST:");
        PrimMST<Double> primMST = new PrimMST<Double>(g4);
        List<Edge<Double>> mst = primMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
        System.out.println("The MST weight is: " + primMST.result());

        long endTime = System.currentTimeMillis();
        System.out.println("take time: " + (endTime - startTime) + " ms");
    }

    /**
     * Kruskal 算法，求最小生成树
     */
    @Test
    public void kruskal() {
        long startTime = System.currentTimeMillis();

        System.out.println("Test Kruskal MST:");
        KruskalMST<Double> kruskalMST = new KruskalMST<Double>(g1);
        List<Edge<Double>> mst = kruskalMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
        System.out.println("The Kruskal weight is: " + kruskalMST.result());

        long endTime = System.currentTimeMillis();
        System.out.println("take time: " + (endTime - startTime) + " ms");
    }

}