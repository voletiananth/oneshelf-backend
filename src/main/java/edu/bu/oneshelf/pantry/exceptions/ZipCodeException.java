package edu.bu.oneshelf.pantry.exceptions;

import edu.bu.oneshelf.common.NotFoundException;

public class ZipCodeException extends NotFoundException {
    public ZipCodeException(String message) {
        super(message);
    }
}
