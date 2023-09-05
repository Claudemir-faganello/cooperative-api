package br.com.cooperativeapi.entity.session;

import br.com.cooperativeapi.entity.topic.Topic;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "session")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "open_date")
    private LocalDateTime openDate;
    @Column(name = "close_date")
    private LocalDateTime closeDate;

    @OneToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Boolean isClosed() {
        return this.closeDate.isBefore(LocalDateTime.now());
    }

}
