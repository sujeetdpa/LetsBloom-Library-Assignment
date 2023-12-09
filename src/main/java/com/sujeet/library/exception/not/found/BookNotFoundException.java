package com.sujeet.library.exception.not.found;

public class BookNotFoundException extends LibraryNotFoundException{
    public BookNotFoundException(Throwable cause) {
        super(cause);
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
