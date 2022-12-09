package com.journey.algorithm.common.sort;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Swap {

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
