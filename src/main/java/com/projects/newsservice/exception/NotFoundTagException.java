package com.projects.newsservice.exception;

public class NotFoundTagException extends RuntimeException {
    public NotFoundTagException(String tagName) {
        super(tagName + "not found");
    }
}
