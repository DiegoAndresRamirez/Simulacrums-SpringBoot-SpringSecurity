package com.events.riwi.infrastructure.dto.userDtos;

import com.events.riwi.utils.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateResponseDTO {
    private String message;

    private Role role;
}
