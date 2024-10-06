package com.riwi.library.application.services;

import com.riwi.library.application.IModels.IModelUser;
import com.riwi.library.domain.models.User;
import com.riwi.library.domain.persistence.UserRepository;
import com.riwi.library.infrastructure.dto.request.userRequestDtos.UserCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.userResponseDtos.UserCreateResponseDTO;
import com.riwi.library.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IModelUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserCreateResponseDTO create(UserCreateRequestDTO userCreateRequestDTO) {

        User user = User.builder()
                .name(userCreateRequestDTO.getName())
                .surname(userCreateRequestDTO.getSurname())
                .email(userCreateRequestDTO.getEmail())
                .password(userCreateRequestDTO.getPassword())
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return UserCreateResponseDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
