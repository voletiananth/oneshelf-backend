package edu.bu.oneshelf.pantry.exceptions;

import edu.bu.oneshelf.common.NotFoundException;

public class PantryDoesNotExistsException extends NotFoundException {
    public PantryDoesNotExistsException(String message) {
        super(message);
    }
}
