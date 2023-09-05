package br.com.cooperativeapi.dto.vote;

import br.com.cooperativeapi.entity.vote.Vote;
import br.com.cooperativeapi.entity.vote.VotePK;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteDTO {

    private String associatedId;
    private Integer topicId;
    private String choose;

    public Vote fromDTO(VoteDTO voteDTO) {
        return Vote.builder()
                .choose(voteDTO.getChoose())
                .votePK(
                        VotePK.builder()
                                .associatedId(voteDTO.getAssociatedId())
                                .topicId(voteDTO.getTopicId())
                                .build()
                ).build();
    }
}
