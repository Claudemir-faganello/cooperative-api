package br.com.cooperativeapi.service.vote;

import br.com.cooperativeapi.client.associated.AssociatedAPI;
import br.com.cooperativeapi.entity.session.Session;
import br.com.cooperativeapi.entity.vote.Vote;
import br.com.cooperativeapi.entity.vote.VotePK;
import br.com.cooperativeapi.repository.vote.VoteRepository;
import br.com.cooperativeapi.service.session.SessionService;
import br.com.cooperativeapi.utils.SessionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VoteServiceTest {

    @InjectMocks
    private VoteService voteService = new VoteServiceImpl();

    @Mock
    private SessionService sessionService;

    @Mock
    private VoteRepository voteRepository;
    @Mock
    private AssociatedAPI associatedAPI;

    private String associatedId = "01234567";

    @Before
    public void setup() {
        when(associatedAPI.validateAssociatedDocument(associatedId)).thenReturn(true);

        Session session = SessionUtils.create();
        when(sessionService.findByTopicId(1)).thenReturn(session);

        when(voteRepository.save(any())).thenReturn(new Vote() {{
            setChoose("Sim");
        }});

    }

    @Test
    public void testSave() {
        Vote vote = Vote.builder()
                .choose("Sim")
                .votePK(
                        VotePK.builder()
                                .associatedId(associatedId)
                                .topicId(1)
                                .build()
                ).build();
        Vote savedVote = voteService.save(vote);
        assertEquals(vote.getChoose(), savedVote.getChoose());
        verify(voteRepository).save(vote);
    }

    @Test
    public void testFindById() {
        VotePK votePK = VotePK.builder()
                .associatedId(associatedId)
                .topicId(1)
                .build();
        voteService.findById(votePK);
        verify(voteRepository).findById(votePK);
    }
}
