package binarysearchtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    Integer[] arr;

    @BeforeEach
    public void generateArr() {
        // 初始化 arr， 数据值等于索引值
        int N = 1000000;
        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
    }

    @Test
    public void find1() {
        for (int i = 0; i < 2 * arr.length; i++) {
            int v = BinarySearch.find1(arr, i);
            if (i < arr.length)
                assert v == i;
            else
                assert v == -1;
        }
    }

    @Test
    public void find2() {
        for (int i = 0; i < 2 * arr.length; i++) {
            int v = BinarySearch.find2(arr, i);
            if (i < arr.length)
                assert v == i;
            else
                assert v == -1;
        }
    }
}