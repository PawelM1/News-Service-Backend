package com.projects.newsservice.controller;

import com.projects.newsservice.Service.PostService;
import com.projects.newsservice.dto.PostDto;
import com.projects.newsservice.dto.PostRequest;
import com.projects.newsservice.entity.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest, @AuthenticationPrincipal UsernamePasswordAuthenticationToken user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(postRequest, user.getName()));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPost());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostById(id));
    }

    @GetMapping("tag/{tagName}")
    public ResponseEntity<List<PostDto>> getPostByTag(@PathVariable String tagName) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostByTag(tagName));
    }

    @GetMapping("user/{userName}")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable String userName) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostByUser(userName));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable("id") Long id, @RequestBody PostRequest postRequest, @AuthenticationPrincipal UsernamePasswordAuthenticationToken user)
    {
        postService.updatePost(id, postRequest, user.getName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id, @AuthenticationPrincipal UsernamePasswordAuthenticationToken user){
        postService.deletePost(id, user.getName());
        return ResponseEntity.noContent().build();
    }
}
