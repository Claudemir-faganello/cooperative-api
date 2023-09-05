package br.com.cooperativeapi.service.topic;

import br.com.cooperativeapi.entity.topic.Topic;
import br.com.cooperativeapi.exception.ObjectNotFoundException;
import br.com.cooperativeapi.repository.topic.TopicRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Service
@Log4j2
public class TopicServiceImpl implements TopicService {

    @Resource
    private TopicRepository topicRepository;

    @Override
    public Topic save(@Valid Topic topic) {
        log.info("Criando nova pauta/topico: " + topic.getName());
        return this.topicRepository.save(topic);
    }

    @Override
    public List<Topic> findAll() {
        log.info("Listando pautas/topicos");
        return this.topicRepository.findAll();
    }

    @Override
    public Topic findById(Integer id) {
        return this.topicRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Tópico/Pauta não existe"));
    }
}
