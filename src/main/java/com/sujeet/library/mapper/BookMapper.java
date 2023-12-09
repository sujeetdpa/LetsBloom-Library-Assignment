package com.sujeet.library.mapper;

import com.sujeet.library.beans.request.NewBookRequest;
import com.sujeet.library.beans.response.BookResponse;
import com.sujeet.library.models.Book;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookMapper {
    public Book map(NewBookRequest bookRequest){
        Book book=new Book();
        Optional.ofNullable(bookRequest.getTitle()).ifPresent(book::setTitle);
        Optional.ofNullable(bookRequest.getDescription()).ifPresent(book::setDescription);
        Optional.ofNullable(bookRequest.getSbin()).ifPresent(book::setSbin);
        Optional.ofNullable(bookRequest.getAuthor()).ifPresent(book::setAuthor);
        Optional.ofNullable(bookRequest.getPublicationDate()).ifPresent(book::setPublicationDate);
        return book;
    }

    public BookResponse map(Book book){
        BookResponse bookResponse=new BookResponse();
        Optional.ofNullable(book.getId()).ifPresent(bookResponse::setId);
        Optional.ofNullable(book.getTitle()).ifPresent(bookResponse::setTitle);
        Optional.ofNullable(book.getDescription()).ifPresent(bookResponse::setDescription);
        Optional.ofNullable(book.getSbin()).ifPresent(bookResponse::setSbin);
        Optional.ofNullable(book.getAuthor()).ifPresent(bookResponse::setAuthor);
        Optional.ofNullable(book.getPublicationDate()).ifPresent(bookResponse::setPublicationDate);
        Optional.ofNullable(book.getCreationTimestamp()).ifPresent(bookResponse::setCreationTimestamp);

        return bookResponse;
    }
}
