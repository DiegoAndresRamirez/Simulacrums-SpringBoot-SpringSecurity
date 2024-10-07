package com.events.riwi.application.interfaces;

import com.events.riwi.infrastructure.dto.userDtos.UserCreateRequestDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserGetResponseDTO;

import java.util.List;

public interface IUserService {

    UserCreateResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO);

    List<UserGetResponseDTO> getAllUsers();

    UserGetResponseDTO getUserById(Long id);

    String deleteUser(Long id);

    String updateUser(Long id, UserCreateRequestDTO userCreateRequestDTO);

}
