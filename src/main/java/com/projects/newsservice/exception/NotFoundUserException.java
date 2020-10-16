package com.projects.newsservice.exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException() {
        super("User not exist or your session expired");
    }
}
