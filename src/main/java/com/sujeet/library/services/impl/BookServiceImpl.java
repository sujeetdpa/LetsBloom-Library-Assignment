package com.sujeet.library.services.impl;

import com.sujeet.library.beans.request.NewBookRequest;
import com.sujeet.library.beans.response.BookResponse;
import com.sujeet.library.exception.not.found.BookNotFoundException;
import com.sujeet.library.mapper.BookMapper;
import com.sujeet.library.models.Book;
import com.sujeet.library.repository.BookRepository;
import com.sujeet.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        Iterable<Book> books = bookRepository.findAll();
        List<BookResponse> responseList=new ArrayList<>();
        books.forEach(book -> {
            responseList.add(bookMapper.map(book));
        });
        return responseList;
    }

    @Override
    public BookResponse addBook(NewBookRequest bookRequest) {
        Book book=bookMapper.map(bookRequest);
        book.setCreationTimestamp(LocalDateTime.now());
        Book newBook = bookRepository.save(book);
        BookResponse bookResponse = bookMapper.map(newBook);
        return bookResponse;
    }

    @Override
    public BookResponse updateBook(Long id, NewBookRequest bookRequest) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        Optional.ofNullable(bookRequest.getTitle()).ifPresent(book::setTitle);
        Optional.ofNullable(bookRequest.getDescription()).ifPresent(book::setDescription);
        Optional.ofNullable(bookRequest.getAuthor()).ifPresent(book::setAuthor);
        Optional.ofNullable(bookRequest.getPublicationDate()).ifPresent(book::setPublicationDate);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.map(updatedBook);
    }
}
