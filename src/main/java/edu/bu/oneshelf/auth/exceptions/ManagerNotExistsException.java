package edu.bu.oneshelf.auth.exceptions;

import edu.bu.oneshelf.common.NotFoundException;

public class ManagerNotExistsException extends NotFoundException {
    public ManagerNotExistsException(String message) {
        super(message);
    }
}
