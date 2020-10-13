package com.projects.newsservice.repository;

import com.projects.newsservice.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepo extends JpaRepository<Tag, Long> {
    Optional<Tag> getTagByName(String name);
}
