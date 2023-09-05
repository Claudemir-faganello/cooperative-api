package br.com.cooperativeapi.controller.v1.vote;

import br.com.cooperativeapi.dto.vote.VoteDTO;
import br.com.cooperativeapi.service.vote.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/v1/vote")
@Api(value = "Vote")
public class VoteRestController {

    @Resource
    private VoteService voteService;

    @PostMapping
    @ApiOperation(value = "API usada para criar um novo voto", response = VoteDTO.class)
    public ResponseEntity<Void> save(@RequestBody VoteDTO voteDTO) {
        this.voteService.save(voteDTO.fromDTO(voteDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
