package edu.bu.oneshelf.common;

import com.fasterxml.jackson.databind.introspect.Annotated;
import edu.bu.oneshelf.pantry.exceptions.PantryExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Annotation;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@ControllerAdvice
public class ExceptionHandler {

@ResponseStatus(value = HttpStatus.CONFLICT)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = ConflictException.class)
public @ResponseBody ErrorResponse handlePantriesExistsException(ConflictException e) {

    return new ErrorResponse(e.getStatusCode(), e.getMessage());


}


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    public @ResponseBody ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringJoiner sb = new StringJoiner(" , ");
        e.getBindingResult().getFieldErrors().forEach(error -> sb.add(error.getDefaultMessage()));
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), sb.toString());
    }






    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = BindException.class)
    public @ResponseBody ErrorResponse handleBindExecption(BindException e) {
        StringJoiner sb = new StringJoiner(" , ");
        e.getBindingResult().getFieldErrors().forEach(error -> sb.add(error.getDefaultMessage()));
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), sb.toString());
    }




    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = BadRequestException.class)
    public @ResponseBody  ErrorResponse handleBadRequestException(BadRequestException e) {
        return new ErrorResponse(e.getStatusCode(), e.getMessage());
    }


    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = UnAuthorizedException.class)
    public @ResponseBody ErrorResponse handleUnAuthorizedException(UnAuthorizedException e) {
        return new ErrorResponse(e.getStatusCode(), e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotFoundException.class)
    public @ResponseBody ErrorResponse handleNotFoundException(NotFoundException e) {

        return new ErrorResponse(e.getStatusCode(), e.getMessage());
    }
}
