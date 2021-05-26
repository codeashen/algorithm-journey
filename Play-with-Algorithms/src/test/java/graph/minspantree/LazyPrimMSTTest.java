package graph.minspantree;

import org.junit.Test;

import java.util.List;

public class LazyPrimMSTTest {

    @Test
    public void lazyPrim() {
        // 读取testG1.txt文件表示的图，第一行表示节点数和边数
        String filename = "graph/minspantree/testG1.txt";
        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(8, false);
        ReadWeightedGraph.graph(g, filename);
        System.out.println("test G1 in Dense Weight Graph:");
        g.show();

        // 计算 g 的最小生成树
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        List<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
        System.out.println("The MST weight is: " + lazyPrimMST.result());
    }

}