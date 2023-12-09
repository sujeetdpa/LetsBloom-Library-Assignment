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
    @NotBlank
    private String title;

    @NotBlank
    private String isbn;

    private String description;

    @NotBlank
    private String author;

    @NotNull
    private LocalDate publicationDate;
}
