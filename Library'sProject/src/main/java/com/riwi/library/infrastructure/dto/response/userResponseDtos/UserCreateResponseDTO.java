package com.riwi.library.infrastructure.dto.response.userResponseDtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateResponseDTO {
    private String name;
    private String email;
}
