package com.sujeet.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LibraryException extends RuntimeException{
    public LibraryException(Throwable cause) {
        super(cause);
    }
    public LibraryException(String message) {
        super(message);
    }
}
