package com.sujeet.library.exception.not.found;

import com.sujeet.library.exception.LibraryException;

public abstract class LibraryNotFoundException extends LibraryException {
    public LibraryNotFoundException(Throwable cause) {
        super(cause);
    }

    public LibraryNotFoundException(String message) {
        super(message);
    }
}
