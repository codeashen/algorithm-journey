package com.journey.algorithm.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
    }
}
