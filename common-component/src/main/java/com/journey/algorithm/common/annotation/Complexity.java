package com.journey.algorithm.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 算法复杂度
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Complexity {
    /**
     * 时间复杂度
     */
    String time() default "";

    /**
     * 空间复杂度
     */
    String space() default "";
}
