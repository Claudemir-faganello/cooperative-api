package br.com.cooperativeapi.dto.topic;

import br.com.cooperativeapi.entity.topic.Topic;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicDTO {

    private String name;
    private Integer id;

    private Long totalNo;
    private Long totalYes;

    public Topic fromDTO() {
        return Topic.builder()
                .name(name)
                .id(id)
                .build();
    }

    public TopicDTO(Topic topic) {
        setName(topic.getName());
        setId(topic.getId());
        setTotalNo(topic.getTotalNo());
        setTotalYes(topic.getTotalYes());
    }
}
