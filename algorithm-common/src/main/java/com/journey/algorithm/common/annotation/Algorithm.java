package com.journey.algorithm.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识该类为一个算法类
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Algorithm {
    /**
     * 算法主题
     */
    String topic() default "";

    /**
     * 解法
     */
    String solution() default "";
}
