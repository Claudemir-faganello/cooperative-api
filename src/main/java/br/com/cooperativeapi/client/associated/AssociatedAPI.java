package br.com.cooperativeapi.client.associated;

import br.com.cooperativeapi.client.response.AssociatedStatus;
import br.com.cooperativeapi.exception.AssociatedApiException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@Log4j2
public class AssociatedAPI {

    private RestTemplate restTemplate;

    @Value("${associated_api_url}")
    private String associatedApiUrl;

    @Autowired
    public AssociatedAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean validateAssociatedDocument(String document) {
        try {
            log.info("Iniciando consulta de associado!");
            URI uri = URI.create(this.associatedApiUrl.concat("/").concat(document));
            AssociatedStatus userInfoResponse = restTemplate.getForObject(uri, AssociatedStatus.class);
            return userInfoResponse.isAbleToVote();
        } catch (Exception ex) {
            log.error("Erro ao consultar associado: " + document);
            throw new AssociatedApiException("Erro ao consultar associado", ex);
        }
    }
}
