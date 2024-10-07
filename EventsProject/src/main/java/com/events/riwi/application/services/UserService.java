package com.events.riwi.application.services;

import com.events.riwi.application.interfaces.IUserService;
import com.events.riwi.domain.models.User;
import com.events.riwi.domain.persistence.UserRepository;
import com.events.riwi.infrastructure.dto.authDtos.RegisterRequestDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateRequestDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserGetResponseDTO;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserCreateResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO) {
        User userExists = userRepository.findByEmail(userCreateRequestDTO.getEmail());
        if (userExists != null) {
            throw new EntityExistsException("User already exists");
        }

        User user = User.builder()
                .name(userCreateRequestDTO.getName())
                .username(userCreateRequestDTO.getUsername())
                .lastname(userCreateRequestDTO.getLastname())
                .email(userCreateRequestDTO.getEmail())
                .password(userCreateRequestDTO.getPassword())
                .role(userCreateRequestDTO.getRole())
                .build();

        userRepository.save(user);

        return UserCreateResponseDTO.builder()
                .message("User created successfully")
                .role(user.getRole())
                .build();
    }

    @Override
    public List<UserGetResponseDTO> getAllUsers() {
        List<UserGetResponseDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(UserGetResponseDTO.builder()
                    .name(user.getName())
                    .username(user.getUsername())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .build());
        });
        return users;
    }

    @Override
    public UserGetResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserGetResponseDTO.builder()
                .name(user.getName())
                .username(user.getUsername())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        userRepository.delete(user);
        return "User deleted successfully";
    }

    @Override
    public String updateUser(Long id, UserCreateRequestDTO userCreateRequestDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        user.setId(id);
        user.setName(userCreateRequestDTO.getName());
        user.setUsername(userCreateRequestDTO.getUsername());
        user.setLastname(userCreateRequestDTO.getLastname());
        user.setEmail(userCreateRequestDTO.getEmail());
        user.setPassword(userCreateRequestDTO.getPassword());
        user.setRole(userCreateRequestDTO.getRole());

        userRepository.save(user);
        return "User updated successfully";
    }

}
