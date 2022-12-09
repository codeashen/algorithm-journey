package com.journey.algorithm.common.util;

import com.google.common.base.Stopwatch;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class SortingHelper {

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
    public static <E extends Comparable<E>> void sortElapse(Class clazz, E[] arr) {
        try {
            Method sort = clazz.getMethod("sort", Comparable[].class);

            Stopwatch stopwatch = Stopwatch.createStarted();
            sort.invoke(null, (Object) arr);
            stopwatch.stop();

            System.out.printf("%s 排序 %d 个元素，耗时 %s 毫秒\n",
                    clazz.getSimpleName(),
                    arr.length,
                    stopwatch.elapsed(TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
