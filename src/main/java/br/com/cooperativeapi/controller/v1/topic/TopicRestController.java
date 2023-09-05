package br.com.cooperativeapi.controller.v1.topic;

import br.com.cooperativeapi.dto.topic.TopicDTO;
import br.com.cooperativeapi.service.topic.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/topic")
@Api(value = "Topic")
public class TopicRestController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    @ApiOperation(value = "API usada para criar tópico/pauta", response = TopicDTO.class)
    public ResponseEntity<?> save(@RequestBody TopicDTO topicDTO) {
        return ResponseEntity.ok(
                new TopicDTO(this.topicService.save(topicDTO.fromDTO()))
        );
    }

    @GetMapping
    public ResponseEntity<List<TopicDTO>> findAll() {
        return ResponseEntity.ok(
                this.topicService.findAll()
                        .stream()
                        .map(TopicDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<?> findById(@PathVariable("topicId") Integer topicId) {
        return ResponseEntity.ok(
                this.topicService.findById(topicId)
        );
    }
}
