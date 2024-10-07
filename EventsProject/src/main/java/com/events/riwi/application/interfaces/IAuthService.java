package com.events.riwi.application.interfaces;

import com.events.riwi.infrastructure.dto.authDtos.LoginRequestDTO;
import com.events.riwi.infrastructure.dto.authDtos.LoginResponseDTO;
import com.events.riwi.infrastructure.dto.authDtos.RegisterRequestDTO;
import com.events.riwi.infrastructure.dto.authDtos.RegisterResponseDTO;
import com.events.riwi.utils.enums.Role;

public interface IAuthService {

    LoginResponseDTO login (LoginRequestDTO loginRequestDTO);

    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO, Role role);

}
