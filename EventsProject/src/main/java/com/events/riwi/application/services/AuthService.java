package com.events.riwi.application.services;

import com.events.riwi.application.interfaces.IAuthService;
import com.events.riwi.domain.models.User;
import com.events.riwi.domain.persistence.UserRepository;
import com.events.riwi.infrastructure.dto.authDtos.LoginRequestDTO;
import com.events.riwi.infrastructure.dto.authDtos.LoginResponseDTO;
import com.events.riwi.infrastructure.dto.authDtos.RegisterRequestDTO;
import com.events.riwi.infrastructure.dto.authDtos.RegisterResponseDTO;
import com.events.riwi.utils.enums.Role;
import com.events.riwi.utils.helpers.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTService jwtService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.getEmail());

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return LoginResponseDTO.builder()
                .message("Login successful")
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO, Role role) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            User user = userRepository.findByEmail(authentication.getName());
            if(user != null) {
                throw new UsernameNotFoundException("User already exists");
            }
        }

        User user = User.builder()
                .name(registerRequestDTO.getName())
                .username(registerRequestDTO.getUsername())
                .lastname(registerRequestDTO.getLastname())
                .email(registerRequestDTO.getEmail())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .role(role)
                .build();

        userRepository.save(user);

        return RegisterResponseDTO.builder()
                .message("User registered successfully")
                .role(role)
                .build();
    }
}
