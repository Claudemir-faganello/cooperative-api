package br.com.cooperativeapi.service.vote;

import br.com.cooperativeapi.client.associated.AssociatedAPI;
import br.com.cooperativeapi.entity.session.Session;
import br.com.cooperativeapi.entity.topic.Topic;
import br.com.cooperativeapi.entity.vote.Vote;
import br.com.cooperativeapi.entity.vote.VotePK;
import br.com.cooperativeapi.repository.topic.TopicRepository;
import br.com.cooperativeapi.repository.vote.VoteRepository;
import br.com.cooperativeapi.service.session.SessionService;
import br.com.cooperativeapi.service.topic.TopicService;
import br.com.cooperativeapi.service.topic.TopicServiceImpl;
import br.com.cooperativeapi.utils.SessionUtils;
import br.com.cooperativeapi.utils.TopicUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        verify(topicRepository).save(topic);
    }

    @Test
    public void testFindAll() {
        topicService.findAll();
        verify(topicRepository).findAll();
    }

    @Test
    public void testFindById() {
        Topic previous = TopicUtils.create();
        when(topicRepository.findById(1)).thenReturn(Optional.of(previous));
        Topic current = topicService.findById(1);
        verify(topicRepository).findById(1);
        assertEquals(previous, current);
    }

}
