package br.com.cooperativeapi.service.topic;

import br.com.cooperativeapi.entity.topic.Topic;
import br.com.cooperativeapi.repository.topic.TopicRepository;
import br.com.cooperativeapi.utils.TopicUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TopicServiceTest {

    @InjectMocks
    private TopicService topicService = new TopicServiceImpl();

    @Mock
    private TopicRepository topicRepository;

    @Test
    public void testSave() {
        Topic topic = TopicUtils.create();
        topicService.save(topic);

        Mockito.verify(topicRepository).save(topic);
    }

    @Test
    public void testFindAll() {
        topicService.findAll();
        Mockito.verify(topicRepository).findAll();
    }

    @Test
    public void testFindById() {
        Topic previous = TopicUtils.create();
        Mockito.when(topicRepository.findById(1)).thenReturn(Optional.of(previous));
        Topic current = topicService.findById(1);
        Mockito.verify(topicRepository).findById(1);
        Assert.assertEquals(previous, current);
    }

}
