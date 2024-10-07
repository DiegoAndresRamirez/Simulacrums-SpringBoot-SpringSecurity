package com.events.riwi.infrastructure.interfaces;

import com.events.riwi.infrastructure.dto.authDtos.LoginRequestDTO;
import com.events.riwi.infrastructure.dto.authDtos.RegisterRequestDTO;
import com.events.riwi.utils.enums.Role;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAuthController {

    ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO);

    ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO,
                               @RequestParam(required = false, defaultValue = "USER") Role role);

}
