package com.events.riwi.infrastructure.dto.authDtos;

import com.events.riwi.utils.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDTO {
    private String message;

    private Role role;
}
