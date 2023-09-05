package br.com.cooperativeapi.controller.v1.session;

import br.com.cooperativeapi.service.session.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/v1/session")
@Api(value = "Session")
public class SessionRestController {

    @Resource
    private SessionService sessionService;

    @PostMapping("/{topicId}")
    @ApiOperation(value = "API usada para abrir uma sessão em uma pauta")
    public ResponseEntity<Void> open(@PathVariable("topicId") Integer topicId) {
        this.sessionService.create(topicId);
        return ResponseEntity.noContent().build();
    }
}
