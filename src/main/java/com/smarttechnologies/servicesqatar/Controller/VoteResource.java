package com.smarttechnologies.servicesqatar.Controller;

import com.smarttechnologies.servicesqatar.Services.VoteService;
import com.smarttechnologies.servicesqatar.dto.VoteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.status;
@RestController
@RequestMapping("/api/votes/")
public class VoteResource {
    private final VoteService voteService;

    public VoteResource(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<Void> vote(@RequestBody VoteDto voteDto) {
        voteService.vote(voteDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
