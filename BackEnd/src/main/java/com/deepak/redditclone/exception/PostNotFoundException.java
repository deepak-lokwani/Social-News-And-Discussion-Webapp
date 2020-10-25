package com.deepak.redditclone.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String s) {
        super(s);
    }
}
