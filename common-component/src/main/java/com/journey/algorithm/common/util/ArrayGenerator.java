package com.journey.algorithm.common.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class ArrayGenerator {

    /**
     * 生成有序数组
     *
     * @param n 数组长度
     * @return
     */
    public static Integer[] createOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成随机数组
     *
     * @param n     数组长度
     * @param bound 数组元素范围 [0, bound)
     * @return
     */
    public static Integer[] createRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static Integer[] createRandomArray(int n) {
        return createRandomArray(n, n * 2);
    }
}
