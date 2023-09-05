package br.com.cooperativeapi.service.topic;

import br.com.cooperativeapi.entity.topic.Topic;

import java.util.List;

public interface TopicService {

    Topic save(Topic topic);

    List<Topic> findAll();

    Topic findById(Integer topicId);
}
