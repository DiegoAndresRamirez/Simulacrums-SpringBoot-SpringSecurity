package com.riwi.library.infrastructure.dto.request.categoryRequestDtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryCreateRequestDTO {
    private String name;
    private String description;
}
