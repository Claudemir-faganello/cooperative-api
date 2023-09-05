package br.com.cooperativeapi.entity.topic;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "topic")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Nome é obrigatório")
    @NotEmpty(message = "Nome não pode ser vazio")
    private String name;

    @Formula(" (SELECT COUNT(*) FROM vote v WHERE v.choose = 'Não' AND v.topic_id = id )")
    private Long totalNo;

    @Formula(" (SELECT COUNT(*) FROM vote v WHERE v.choose = 'Sim' AND v.topic_id = id )")
    private Long totalYes;
}
