package edu.bu.oneshelf.common;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;


public abstract class BaseException extends RuntimeException{

    private final HttpStatus status;
    private final String message;

    public BaseException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatusCode() {
        return status.value();
    }

    public HttpStatus getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
}
