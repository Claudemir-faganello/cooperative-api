package br.com.cooperativeapi.entity.vote;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VotePK implements Serializable {
    @Column(name = "associated_id")
    private String associatedId;
    @Column(name = "topic_id")
    private Integer topicId;
}
