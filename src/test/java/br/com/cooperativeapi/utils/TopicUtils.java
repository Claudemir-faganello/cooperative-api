package br.com.cooperativeapi.utils;

import br.com.cooperativeapi.entity.topic.Topic;

public class TopicUtils {

    public static Topic create() {
        return Topic.builder()
                .id(1)
                .name("abc")
                .build();
    }
}
