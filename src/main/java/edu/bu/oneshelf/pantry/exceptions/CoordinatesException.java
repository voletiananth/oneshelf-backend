package edu.bu.oneshelf.pantry.exceptions;

import edu.bu.oneshelf.common.NotFoundException;

public class CoordinatesException extends NotFoundException{
    public CoordinatesException(String message) {
        super(message);
    }
}
