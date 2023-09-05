package br.com.cooperativeapi.service.vote;

import br.com.cooperativeapi.entity.vote.Vote;
import br.com.cooperativeapi.entity.vote.VotePK;

public interface VoteService {

    Vote save(Vote vote);

    Vote findById(VotePK votePK);
}
