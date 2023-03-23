package edu.bu.oneshelf.products.exceptions;

import edu.bu.oneshelf.common.NotFoundException;

public class ProductDetailsNotExistsException extends NotFoundException{
    public ProductDetailsNotExistsException(String message) {
        super(message);
    }
}
