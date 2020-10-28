package com.projects.newsservice.repository;

import com.projects.newsservice.entity.Post;
import com.projects.newsservice.entity.User;
import com.projects.newsservice.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepo extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByUserAndPostOrderByVoteIdDesc(User user, Post post);

    Optional<Vote> findTopByUser_UsernameAndPostOrderByVoteIdDesc(String user_username, Post post);
}
