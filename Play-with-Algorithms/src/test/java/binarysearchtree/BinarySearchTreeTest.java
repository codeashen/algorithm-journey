package binarysearchtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void test() {
        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }

        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
        for (int i = 0; i < N; i++) {
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));
        }

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(i);
            if (i < N) {
                assertEquals(res, Integer.toString(i));
            } else {
                assertNull(res);
            }
        }

        for (int i = 0; i < N; i++) {
            assertTrue(bst.contain(i));
            bst.remove(i);
            assertFalse(bst.contain(i));
        }
    }
}