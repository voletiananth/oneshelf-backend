package edu.bu.oneshelf.products.exceptions;

import edu.bu.oneshelf.common.BadRequestException;

public class ImageException extends BadRequestException {
    public ImageException(String message) {
        super(message);
    }
}
