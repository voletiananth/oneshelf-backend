package edu.bu.oneshelf.common;

import lombok.Data;
import org.springframework.http.HttpStatus;


public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
