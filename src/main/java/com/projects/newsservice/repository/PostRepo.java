package com.projects.newsservice.repository;

import com.projects.newsservice.entity.Post;
import com.projects.newsservice.entity.Tag;
import com.projects.newsservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> getPostsByTag(Tag tag);

    List<Post> getPostsByAuthor(User author);
}
