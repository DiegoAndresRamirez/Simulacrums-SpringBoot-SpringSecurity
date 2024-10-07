package com.events.riwi.infrastructure.dto.userDtos;

import com.events.riwi.utils.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGetResponseDTO {
    private String name;

    private String username;

    private String lastname;

    private String email;

    private Role role;
}
