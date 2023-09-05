package br.com.cooperativeapi.repository.vote;

import br.com.cooperativeapi.entity.vote.Vote;
import br.com.cooperativeapi.entity.vote.VotePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, VotePK> {
}
