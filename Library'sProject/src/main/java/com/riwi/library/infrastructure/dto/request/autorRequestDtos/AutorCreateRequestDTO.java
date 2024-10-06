package com.riwi.library.infrastructure.dto.request.autorRequestDtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorCreateRequestDTO {
    private String name;
    private String surname;
    private String age;
    private String description;
}
