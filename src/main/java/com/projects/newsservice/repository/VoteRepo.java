package com.projects.newsservice.repository;

import com.projects.newsservice.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepo extends JpaRepository<Vote, Long> {

}
