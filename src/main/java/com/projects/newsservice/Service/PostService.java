package com.projects.newsservice.Service;

import com.projects.newsservice.dto.PostDto;
import com.projects.newsservice.dto.PostRequest;
import com.projects.newsservice.entity.*;
import com.projects.newsservice.exception.NotFoundPostException;
import com.projects.newsservice.exception.NotFoundTagException;
import com.projects.newsservice.exception.NotFoundUserException;
import com.projects.newsservice.exception.OtherAppException;
import com.projects.newsservice.repository.PostRepo;
import com.projects.newsservice.repository.TagRepo;
import com.projects.newsservice.repository.UserRepo;
import com.projects.newsservice.repository.VoteRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepo postRepo;
    private TagRepo tagRepo;
    private UserRepo userRepo;
    private VoteRepo voteRepo;

    public PostService(PostRepo postRepo, TagRepo tagRepo, UserRepo userRepo, VoteRepo voteRepo) {
        this.postRepo = postRepo;
        this.tagRepo = tagRepo;
        this.userRepo = userRepo;
        this.voteRepo = voteRepo;
    }

    @Transactional
    public Post save(PostRequest postRequest, String username) {
        Tag tag = tagRepo.getTagByName(postRequest.getTag()).orElseGet(() -> tagRepo.save(new Tag(postRequest.getTag())));
        Post post = new Post();
        post.setAuthor(userRepo.findByUsername(username).orElseThrow(NotFoundUserException::new));
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setImgUrl(postRequest.getImageUrl());
        post.setNews_url(postRequest.getNews_url());
        post.setTag(tag);
        post.setVoteResult(0);
        return postRepo.save(post);
    }

    public List<PostDto> getAllPost() {
        List<Post> posts = postRepo.findAll();
        return posts.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public List<PostDto> getPostByTag(String tagName) {
        Tag tag = tagRepo.getTagByName(tagName).orElseThrow(() -> new NotFoundTagException(tagName));
        return postRepo.getPostsByTag(tag).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public List<PostDto> getPostByUser(String username) {
        User user = userRepo.findByUsername(username).orElseThrow(NotFoundUserException::new);
        return postRepo.getPostsByAuthor(user).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public PostDto getPostById(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new NotFoundPostException("Post with given id not exist"));
        return this.convertToDto(post);
    }

    @Transactional
    public void updatePost(Long id, PostRequest newPost, String userName) {
        Post post = postRepo.findById(id).orElseThrow(() -> new NotFoundPostException("Post with given id not exist"));
        if (!post.getAuthor().getUsername().equals(userName))
            throw new OtherAppException("You are not author of post!!!");


        updatePostFromPostRequest(post, newPost);
        postRepo.save(post);
    }

    private PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setPostId(post.getPost_id());
        postDto.setTitle(post.getTitle());
        postDto.setUrl(post.getNews_url());
        postDto.setContent(post.getContent());
        postDto.setNewsImage(post.getImgUrl());
        postDto.setVoteResult(post.getVoteResult());
        postDto.setAuthor(post.getAuthor().getUsername());
        postDto.setTag(post.getTag().getName());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            Optional<Vote> voteForPostByUser = voteRepo.findTopByUser_UsernameAndPostOrderByVoteIdDesc(authentication.getName(), post);
            voteForPostByUser.ifPresent(vote -> {
                if (vote.getVoteType().equals(VoteType.PLUS)) {
                    postDto.setUpVote(true);
                    postDto.setDownVote(false);
                } else if (vote.getVoteType().equals(VoteType.MINUS)) {
                    postDto.setUpVote(false);
                    postDto.setDownVote(true);
                }
            });
        }

        return postDto;
    }

    public void updatePostFromPostRequest(Post post, PostRequest postRequest) {
        post.setTitle(postRequest.getTitle());
        post.setNews_url(postRequest.getNews_url());
        post.setContent(postRequest.getContent());
        post.setImgUrl(postRequest.getImageUrl());

        //if user edit tag, save tag if new and set newTag to post
        if (!post.getTag().getName().equals(postRequest.getTag())) {
            Tag tag = tagRepo.getTagByName(postRequest.getTag()).orElseGet(() -> tagRepo.save(new Tag(postRequest.getTag())));
            post.setTag(tag);
            //Todo: Implement: If old tag don't have post, delete it
        }
    }
}
