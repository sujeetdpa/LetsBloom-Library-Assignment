package com.sujeet.library.beans.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBookRequest {
    @NotBlank(message = "Book title cannot be empty.")
    private String title;

    @NotBlank(message = "SBIN cannot be empty.")
    private String sbin;

    private String description;

    @NotBlank(message = "Book author cannot be empty")
    private String author;

    @NotNull(message = "Publication date cannot be null")
    private LocalDate publicationDate;
}
