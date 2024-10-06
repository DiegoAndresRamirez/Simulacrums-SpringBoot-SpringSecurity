package com.riwi.library.infrastructure.dto.request.bookRequestDtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateRequestDTO {

    private String title;
    private String author;
    private String year;
    private String description;
}
