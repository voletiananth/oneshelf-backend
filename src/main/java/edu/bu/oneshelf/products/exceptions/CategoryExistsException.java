package edu.bu.oneshelf.products.exceptions;

import edu.bu.oneshelf.common.ConflictException;

public class CategoryExistsException extends ConflictException {
    public CategoryExistsException(String message) {
        super(message);
    }
}
