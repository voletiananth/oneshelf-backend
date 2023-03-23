package edu.bu.oneshelf.common;

import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends BaseException{
    public UnAuthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
