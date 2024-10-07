package com.events.riwi.infrastructure.controllers;

import com.events.riwi.application.interfaces.IAuthService;
import com.events.riwi.infrastructure.dto.authDtos.LoginRequestDTO;
import com.events.riwi.infrastructure.dto.authDtos.RegisterRequestDTO;
import com.events.riwi.infrastructure.interfaces.IAuthController;
import com.events.riwi.utils.enums.Role;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController implements IAuthController {

    @Autowired
    IAuthService authService;


    @Override
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        try{
            return ResponseEntity.status(200).body(authService.login(loginRequestDTO));
        }catch (UsernameNotFoundException e){
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO,@RequestParam Role role) {
        try {
            return ResponseEntity.status(201).body(authService.register(registerRequestDTO, role));
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body("User already exists");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(404).body("Role not found");
        }
    }
}
