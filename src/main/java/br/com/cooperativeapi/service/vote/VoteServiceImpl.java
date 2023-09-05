package br.com.cooperativeapi.service.vote;

import br.com.cooperativeapi.client.associated.AssociatedAPI;
import br.com.cooperativeapi.entity.session.Session;
import br.com.cooperativeapi.entity.vote.Vote;
import br.com.cooperativeapi.entity.vote.VotePK;
import br.com.cooperativeapi.exception.ForbiddenException;
import br.com.cooperativeapi.exception.ObjectNotFoundException;
import br.com.cooperativeapi.repository.vote.VoteRepository;
import br.com.cooperativeapi.service.session.SessionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
@Log4j2
public class VoteServiceImpl implements VoteService {

    @Resource
    private VoteRepository voteRepository;

    @Resource
    private SessionService sessionService;

    @Resource
    private AssociatedAPI associatedAPI;

    @Override
    public Vote save(Vote vote) {
        final Boolean ableToVote = this.associatedAPI.validateAssociatedDocument(vote.getVotePK().getAssociatedId());
        log.info("Associado: " + vote.getVotePK().getAssociatedId() + " realizando voto...");
        if (!ableToVote) {
            throw new ForbiddenException("Associado inapto para votar: " + vote.getVotePK().getAssociatedId());
        }

        Session session = this.sessionService.findByTopicId(vote.getVotePK().getTopicId());
        if (Objects.isNull(session)) {
            throw new ObjectNotFoundException("Sessão não existe");
        }
        if (session.isClosed()) {
            throw new ForbiddenException("Sessão já encerrada para esta pauta!");
        }
        Vote previousVote = this.findById(vote.getVotePK());
        if (!Objects.isNull(previousVote)) {
            throw new ForbiddenException("Associado já votou nesta pauta!");
        }
        Vote savedVote = this.voteRepository.save(vote);
        log.info("Associado " + vote.getVotePK().getAssociatedId() + " realizou um voto com sucesso");
        return savedVote;
    }

    @Override
    public Vote findById(VotePK votePK) {
        return this.voteRepository.findById(votePK)
                .orElse(null);
    }
}
