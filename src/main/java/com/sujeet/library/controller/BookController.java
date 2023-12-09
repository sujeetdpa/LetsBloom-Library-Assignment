package com.sujeet.library.controller;

import com.sujeet.library.beans.request.NewBookRequest;
import com.sujeet.library.beans.request.UpdateBookRequest;
import com.sujeet.library.beans.response.BookResponse;
import com.sujeet.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books",produces = "application/json")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        List<BookResponse> responseList=bookService.getAllBooks();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody NewBookRequest bookRequest){
        BookResponse response=bookService.addBook(bookRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Long id , @RequestBody UpdateBookRequest bookRequest){
        BookResponse response=bookService.updateBook(id,bookRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
