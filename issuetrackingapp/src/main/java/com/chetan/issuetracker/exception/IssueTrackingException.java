package com.chetan.issuetracker.exception;

public class IssueTrackingException extends RuntimeException {

    public IssueTrackingException() {}

    public IssueTrackingException(String message) {
        super(message);
    }
}