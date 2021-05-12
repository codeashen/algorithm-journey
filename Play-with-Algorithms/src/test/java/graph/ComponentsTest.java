package graph;

import org.junit.Test;

public class ComponentsTest {

    /**
     * 测试计算连通分量
     */
    @Test
    public void componentsTest() {
        // TestG1.txt
        String filename1 = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph.graph(g1, filename1);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph.graph(g2, filename2);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());
    }
}
