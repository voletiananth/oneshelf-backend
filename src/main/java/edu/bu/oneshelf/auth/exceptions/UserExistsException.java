package edu.bu.oneshelf.auth.exceptions;

import edu.bu.oneshelf.common.ConflictException;

public class UserExistsException extends ConflictException {
    public UserExistsException(String message) {
        super(message);
    }
}
