package com.sujeet.library.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    //Unique id for every book
    @Column(unique = true)
    private String isbn;

    private String author;
    private LocalDate publicationDate;
    private LocalDateTime creationTimestamp;
}
