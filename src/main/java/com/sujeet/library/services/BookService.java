package com.sujeet.library.services;

import com.sujeet.library.beans.request.NewBookRequest;
import com.sujeet.library.beans.request.UpdateBookRequest;
import com.sujeet.library.beans.response.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();

    BookResponse addBook(NewBookRequest bookRequest);

    BookResponse updateBook(Long id, UpdateBookRequest bookRequest);
}
