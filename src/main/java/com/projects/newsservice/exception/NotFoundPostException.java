package com.projects.newsservice.exception;

public class NotFoundPostException extends RuntimeException {

    public NotFoundPostException(String post) {
        super("Post " + post + " not found");
    }
}
