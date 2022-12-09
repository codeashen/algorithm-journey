package com.codeashen.journey.algorithm.common.annotation;

import com.alibaba.fastjson2.JSON;
import com.journey.algorithm.common.util.IOUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TopicTagsTest {
    @Test
    public void generateTopicTagsEnum() {
        String json = IOUtils.classpathFileToString("topic-tags.json");
        List<TopicTag> list = JSON.parseArray(json, TopicTag.class);
        for (TopicTag item : list) {
            String name = item.getName().replaceAll(" ", "_").replaceAll("-", "_");
            System.out.printf("%s(\"%s\"),\n", name, item.getTranslatedName());
        }
    }
}
