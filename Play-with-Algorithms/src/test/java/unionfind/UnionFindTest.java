package unionfind;

import org.junit.Test;

public class UnionFindTest {

    @Test
    public void unionFind1() {
        int n = 1000000;
        // test(new UnionFind1(n));
        // test(new UnionFind2(n));
        test(new UnionFind3(n));
        test(new UnionFind4(n));
        test(new UnionFind5(n));
        test(new UnionFind6(n));
    }

    private void test(UnionFind uf) {
        int n = uf.size();
        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.unionElements(a, b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println(2 * n + " ops, " + (endTime - startTime) + " ms");
    }


}