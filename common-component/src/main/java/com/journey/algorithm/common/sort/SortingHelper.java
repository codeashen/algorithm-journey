package com.journey.algorithm.common.sort;

import com.google.common.base.Stopwatch;
import com.journey.algorithm.common.util.ArrayGenerator;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class SortingHelper {

    private static final String DEFAULT_SORT_METHOD = "sort";
    private static final int DEFAULT_ARRAY_LENGTH = 10000;

    /**
     * 判断数组是否有序
     *
     * @param arr 数组
     * @param <E> 数组元素
     * @return 是否有序
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试排序算法耗时
     *
     * @param clazz 排序算法类，必须有名为 sort 的静态方法
     * @param arr   待排序数组
     * @param <E>   数组元素类型
     */
    public static <E extends Comparable<E>> void sortTest(Class clazz, String method, E[] arr) {
        Stopwatch stopwatch;
        try {
            Method sort = clazz.getMethod(method, Comparable[].class);

            stopwatch = Stopwatch.createStarted();
            sort.invoke(null, (Object) arr);
            stopwatch.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!isSorted(arr)) {
            throw new RuntimeException(clazz.getSimpleName() + "#" + method + " sort failed");
        }
        System.out.printf("%s#%s 排序 %d 个元素，耗时 %s 毫秒\n",
                clazz.getSimpleName(), method, arr.length,
                stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }


    public static void sortTest(Class clazz, String method, int n) {
        sortTest(clazz, method, ArrayGenerator.createRandomArray(n));
    }

    public static void sortTest(Class clazz, String method) {
        sortTest(clazz, method, ArrayGenerator.createRandomArray(DEFAULT_ARRAY_LENGTH));
    }

    public static void sortTest(Class clazz, int n) {
        sortTest(clazz, DEFAULT_SORT_METHOD, ArrayGenerator.createRandomArray(n));
    }

    public static void sortTest(Class clazz) {
        sortTest(clazz, DEFAULT_SORT_METHOD, ArrayGenerator.createRandomArray(DEFAULT_ARRAY_LENGTH));
    }
}
