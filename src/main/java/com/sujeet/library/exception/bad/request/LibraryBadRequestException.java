package com.sujeet.library.exception.bad.request;

import com.sujeet.library.exception.LibraryException;

public abstract class LibraryBadRequestException extends LibraryException {
    public LibraryBadRequestException(Throwable cause) {
        super(cause);
    }

    public LibraryBadRequestException(String message) {
        super(message);
    }
}
