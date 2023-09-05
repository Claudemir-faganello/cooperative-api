package br.com.cooperativeapi.service.session;

import br.com.cooperativeapi.entity.session.Session;
import br.com.cooperativeapi.exception.ForbiddenException;
import br.com.cooperativeapi.exception.ObjectNotFoundException;
import br.com.cooperativeapi.repository.session.SessionRepository;
import br.com.cooperativeapi.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Service
public class SessionServiceImpl implements SessionService {

    @Value("${session_time}")
    private Integer sessionTime;

    @Resource
    private SessionRepository sessionRepository;

    @Resource
    private TopicService topicService;

    @Override
    public Session create(final Integer topicId) {
        Session session = this.findByTopicId(topicId);
        if (Objects.isNull(session)) {
            session = Session.builder()
                    .openDate(LocalDateTime.now())
                    .closeDate(LocalDateTime.now().plus(this.sessionTime, ChronoUnit.MINUTES))
                    .topic(topicService.findById(topicId))
                    .build();
            return this.sessionRepository.save(session);
        } else {
            throw new ForbiddenException("Sessão já existe para esta pauta!");
        }
    }

    @Override
    public Session findByTopicId(final Integer topicId) {
        return this.sessionRepository.findByTopic(this.topicService.findById(topicId))
                .orElse(null);
    }

}
