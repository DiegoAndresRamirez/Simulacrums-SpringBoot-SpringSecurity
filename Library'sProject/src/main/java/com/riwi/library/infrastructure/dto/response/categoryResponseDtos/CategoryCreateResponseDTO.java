package com.riwi.library.infrastructure.dto.response.categoryResponseDtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryCreateResponseDTO {

    private String name;
    private String description;
}
