package com.sujeet.library.exception.handlers;

import com.sujeet.library.exception.LibraryException;
import com.sujeet.library.exception.bad.request.LibraryBadRequestException;
import com.sujeet.library.exception.not.found.LibraryNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {
    public final ResponseEntity<LibraryExceptionResponse> handleNotFoundException(LibraryNotFoundException exception){
        HttpStatus status=HttpStatus.NO_CONTENT;
        LibraryExceptionResponse response=new LibraryExceptionResponse();
        response.setError(exception.getMessage());
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(status.value());
        return new ResponseEntity<>(response,status);
    }
    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<LibraryExceptionResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        LibraryExceptionResponse exceptionResponse = new LibraryExceptionResponse();
        exceptionResponse.setError(exception.getMessage());
        exceptionResponse.setStatus(status.value());
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, status);
    }
    @ExceptionHandler({LibraryBadRequestException.class})
    public final ResponseEntity<LibraryExceptionResponse> handleBadRequestException(LibraryBadRequestException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        LibraryExceptionResponse exceptionResponse = new LibraryExceptionResponse();
        exceptionResponse.setError(exception.getMessage());
        exceptionResponse.setStatus(status.value());
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, status);
    }
    @ExceptionHandler({ValidationException.class})
    public final ResponseEntity<LibraryExceptionResponse> handleValidationExceptions(ValidationException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        LibraryExceptionResponse exceptionResponse = new LibraryExceptionResponse();
        exceptionResponse.setError(exception.getMessage());
        exceptionResponse.setStatus(status.value());
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, status);
    }
    @ExceptionHandler({LibraryException.class})
    public ResponseEntity<LibraryExceptionResponse> handelLibraryException(LibraryException exception){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        LibraryExceptionResponse exceptionResponse = new LibraryExceptionResponse();
        exceptionResponse.setError(exception.getMessage());
        exceptionResponse.setStatus(status.value());
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, status);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpStatus statusResponse = HttpStatus.BAD_REQUEST;
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        Iterator var10 = fieldErrors.iterator();

        String error;
        while (var10.hasNext()) {
            FieldError fieldError = (FieldError) var10.next();
            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
            errors.add(error);
        }

        var10 = globalErrors.iterator();

        while (var10.hasNext()) {
            ObjectError globalError = (ObjectError) var10.next();
            error = globalError.getObjectName() + ", " + globalError.getDefaultMessage();
            errors.add(error);
        }
        LibraryExceptionResponse exceptionResponse = new LibraryExceptionResponse();
        exceptionResponse.setError(errors.toString());
        exceptionResponse.setStatus(statusResponse.value());
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, headers, statusResponse);
    }
}
