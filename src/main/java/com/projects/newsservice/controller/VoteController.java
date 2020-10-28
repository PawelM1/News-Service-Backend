package com.projects.newsservice.controller;

import com.projects.newsservice.Service.VoteService;
import com.projects.newsservice.dto.VoteDto;
import com.projects.newsservice.entity.Vote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/votes")
public class VoteController {

    private VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<Vote> save(@RequestBody VoteDto voteDto, @AuthenticationPrincipal UsernamePasswordAuthenticationToken user) {
        return ResponseEntity.status(HttpStatus.OK).body(voteService.save(voteDto, user.getName()));
    }
}
