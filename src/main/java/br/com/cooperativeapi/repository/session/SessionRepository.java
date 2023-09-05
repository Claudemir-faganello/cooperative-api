package br.com.cooperativeapi.repository.session;

import br.com.cooperativeapi.entity.session.Session;
import br.com.cooperativeapi.entity.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    Optional<Session> findByTopic(Topic topic);
}
