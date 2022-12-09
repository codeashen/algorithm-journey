package com.codeashen.journey.algorithm.common.annotation;

import lombok.Data;

@Data
public class TopicTag {
    private String id;
    private String name;
    private String slug;
    private String translatedName;
    private int questionCount;
}
