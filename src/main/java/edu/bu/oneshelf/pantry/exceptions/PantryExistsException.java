package edu.bu.oneshelf.pantry.exceptions;


import edu.bu.oneshelf.common.BaseException;
import edu.bu.oneshelf.common.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PantryExistsException extends ConflictException {
    public PantryExistsException() {
        super("Pantry already exists");
    }

    public PantryExistsException(String pantry_already_exists) {
        super(pantry_already_exists);
    }
}
