package unionfind;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class UnionFindTest {

    @Test
    public void unionFind() {
        int size = 10000000;
        int m = 10000000;

        UnionFind1 uf1 = new UnionFind1(size);
        UnionFind2 uf2 = new UnionFind2(size);
        UnionFind3 uf3 = new UnionFind3(size);
        UnionFind4 uf4 = new UnionFind4(size);
        UnionFind5 uf5 = new UnionFind5(size);
        UnionFind6 uf6 = new UnionFind6(size);

        // System.out.println("uf1 性能测试耗时：" + testUF(uf1, m) + "s");
        // System.out.println("uf2 性能测试耗时：" + testUF(uf2, m) + "s");
        System.out.println("uf3 性能测试耗时：" + testUF(uf3, m) + "s");
        System.out.println("uf4 性能测试耗时：" + testUF(uf4, m) + "s");
        System.out.println("uf5 性能测试耗时：" + testUF(uf5, m) + "s");
        System.out.println("uf6 性能测试耗时：" + testUF(uf6, m) + "s");
    }


    private double testUF(UnionFind uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        // 进行 m 次合并操作
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        // 进行 m 次查询操作
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}