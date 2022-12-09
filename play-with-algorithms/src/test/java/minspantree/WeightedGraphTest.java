package minspantree;

import org.junit.jupiter.api.Test;

public class WeightedGraphTest {

    /**
     * 测试稠密带权图
     */
    @Test
    public void testDenseWeightedGraph() {
        // 读取testG1.txt文件表示的图，第一行表示节点数和边数
        String filename = "minspantree/testG1.txt";
        DenseWeightedGraph<Double> g1 = new DenseWeightedGraph<>(8, false);
        ReadWeightedGraph.graph(g1, filename);
        System.out.println("test G1 in Dense Weight Graph:");
        g1.show();
    }

    /**
     * 测试系数带权图
     */
    @Test
    public void testSparseWeightedGraph() {
        // 读取testG1.txt文件表示的图，第一行表示节点数和边数
        String filename = "minspantree/testG1.txt";
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<>(8, false);
        ReadWeightedGraph.graph(g1, filename);
        System.out.println("test G1 in Dense Weight Graph:");
        g1.show();
    }
}