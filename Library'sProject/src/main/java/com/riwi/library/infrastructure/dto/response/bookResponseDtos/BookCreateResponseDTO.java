package com.riwi.library.infrastructure.dto.response.bookResponseDtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateResponseDTO {

    private String title;
    private String author;
}
