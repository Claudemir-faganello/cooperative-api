package br.com.cooperativeapi.service.vote;

import br.com.cooperativeapi.entity.session.Session;
import br.com.cooperativeapi.entity.topic.Topic;
import br.com.cooperativeapi.exception.ForbiddenException;
import br.com.cooperativeapi.repository.session.SessionRepository;
import br.com.cooperativeapi.service.session.SessionService;
import br.com.cooperativeapi.service.session.SessionServiceImpl;
import br.com.cooperativeapi.service.topic.TopicService;
import br.com.cooperativeapi.utils.SessionUtils;
import br.com.cooperativeapi.utils.TopicUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SessionServiceTest {

    @InjectMocks
    private SessionService sessionService = new SessionServiceImpl();

    @Mock
    private TopicService topicService;
    @Mock
    private SessionRepository sessionRepository;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(sessionService, "sessionTime", 20);
        Topic topic = TopicUtils.create();
        Session session = SessionUtils.create();
        when(sessionRepository.findByTopic(topic)).thenReturn(Optional.of(session));
        when(sessionRepository.save(any())).thenReturn(session);

        when(topicService.findById(1)).thenReturn(topic);
    }

    @Test
    public void testCreate() {
        Session session = sessionService.create(2);
        assertNotNull(session);
    }

    @Test
    public void testFindByTopicId() {
        Session savedSession = sessionService.findByTopicId(1);

        assertNotNull(savedSession);
        verify(sessionRepository).findByTopic(any());
    }

    @Test(expected = ForbiddenException.class)
    public void testCreateExisting() {
        Session session = sessionService.create(1);
        assertNotNull(session);
    }
}
