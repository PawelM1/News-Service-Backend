package com.projects.newsservice.dto;

public class PostRequest {
    private Long post_id;
    private String tag;
    private String title;
    private String news_url;
    private String content;
    private String imageUrl;

    public PostRequest(Long post_id, String tag, String title, String news_url, String content, String imageUrl) {
        this.post_id = post_id;
        this.tag = tag;
        this.title = title;
        this.news_url = news_url;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public PostRequest() {
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
