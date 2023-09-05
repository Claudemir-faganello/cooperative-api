package br.com.cooperativeapi.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociatedStatus {
    private static final String ABLE_TO_VOTE = "ABLE_TO_VOTE";

    private String status;

    public Boolean isAbleToVote() {
        return getStatus().equalsIgnoreCase(ABLE_TO_VOTE);
    }
}
