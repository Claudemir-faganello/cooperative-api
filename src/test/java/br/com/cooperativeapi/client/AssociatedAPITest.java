package br.com.cooperativeapi.client;

import br.com.cooperativeapi.client.associated.AssociatedAPI;
import br.com.cooperativeapi.client.associated.AssociatedAPIImpl;
import br.com.cooperativeapi.client.response.AssociatedStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class AssociatedAPITest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private AssociatedAPI associatedAPI;

    private final String document = "01234567890";

    private String url = "www.google.com";

    @Before
    public void setup() {
        associatedAPI = new AssociatedAPIImpl(restTemplate);
        ReflectionTestUtils.setField(associatedAPI, "associatedApiUrl", url);
    }

    @Test
    public void testValidateAssociatedDocument() {

    }

    @Test
    public void testAbleValidateAssociatedDocument() {
        URI uri = URI.create(url.concat("/").concat(document));

        when(restTemplate.getForObject(uri, AssociatedStatus.class)).thenReturn(new AssociatedStatus("ABLE_TO_VOTE"));

        assertTrue(associatedAPI.validateAssociatedDocument(document));
        verify(restTemplate).getForObject(uri, AssociatedStatus.class);
    }

    @Test
    public void testUnableValidateAssociatedDocument() {
        URI uri = URI.create(url.concat("/").concat(document));

        when(restTemplate.getForObject(uri, AssociatedStatus.class)).thenReturn(new AssociatedStatus("UNABLE_TO_VOTE"));

        assertFalse(associatedAPI.validateAssociatedDocument(document));
        verify(restTemplate).getForObject(uri, AssociatedStatus.class);
    }
}
