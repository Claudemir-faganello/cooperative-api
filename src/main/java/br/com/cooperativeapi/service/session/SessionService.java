package br.com.cooperativeapi.service.session;

import br.com.cooperativeapi.entity.session.Session;

public interface SessionService {

    Session create(Integer id);

    Session findByTopicId(final Integer topicId);


}
