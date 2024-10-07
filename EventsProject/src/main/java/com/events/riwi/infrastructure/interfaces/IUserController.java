package com.events.riwi.infrastructure.interfaces;

import com.events.riwi.infrastructure.dto.userDtos.UserCreateRequestDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserGetResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    ResponseEntity<UserCreateResponseDTO> createUser(UserCreateRequestDTO userCreateRequestDTO);

    ResponseEntity<UserGetResponseDTO> getUserById(Long id);

    ResponseEntity<String> deleteUser(Long id);

    ResponseEntity<String> updateUser(Long id, UserCreateRequestDTO userCreateRequestDTO);

    ResponseEntity<List<UserGetResponseDTO>> getAllUsers();
}
