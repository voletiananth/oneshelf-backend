package edu.bu.oneshelf.common;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException{
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
