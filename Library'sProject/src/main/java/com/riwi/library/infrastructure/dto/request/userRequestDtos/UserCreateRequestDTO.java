package com.riwi.library.infrastructure.dto.request.userRequestDtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequestDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
}
