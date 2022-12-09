package com.journey.algorithm.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识该类的一个 LeetCode 题解类
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface LeetCode {
    /**
     * 题目编号
     */
    int id() default 0;

    /**
     * 题目标题
     */
    String title() default "";

    /**
     * 解法
     */
    String solution() default "";

    /**
     * 标签
     */
    String[] tags() default {};

    /**
     * 是否 accept
     */
    boolean ac() default true;
}
