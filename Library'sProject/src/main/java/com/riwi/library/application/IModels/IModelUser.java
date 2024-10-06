package com.riwi.library.application.IModels;

import com.riwi.library.infrastructure.dto.request.userRequestDtos.UserCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.userResponseDtos.UserCreateResponseDTO;

public interface IModelUser {

    UserCreateResponseDTO create(UserCreateRequestDTO userCreateRequestDTO);
}
