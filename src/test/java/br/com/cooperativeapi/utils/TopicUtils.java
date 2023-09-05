package br.com.cooperativeapi.utils;

import br.com.cooperativeapi.entity.session.Session;
import br.com.cooperativeapi.entity.topic.Topic;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TopicUtils {

    public static Topic create() {
        return Topic.builder()
                .id(1)
                .name("abc")
                .build();
    }
}
