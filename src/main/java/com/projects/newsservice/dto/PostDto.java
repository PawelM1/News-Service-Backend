package com.projects.newsservice.dto;

public class PostDto {
    private Long postId;
    private String title;
    private String url;
    private String content;
    private String newsImage;
    private Integer voteResult;
    private String author;
    private String tag;
    private Boolean upVote;
    private Boolean downVote;

    public PostDto() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public Integer getVoteResult() {
        return voteResult;
    }

    public void setVoteResult(Integer voteResult) {
        this.voteResult = voteResult;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getUpVote() {
        return upVote;
    }

    public void setUpVote(Boolean upVote) {
        this.upVote = upVote;
    }

    public Boolean getDownVote() {
        return downVote;
    }

    public void setDownVote(Boolean downVote) {
        this.downVote = downVote;
    }
}