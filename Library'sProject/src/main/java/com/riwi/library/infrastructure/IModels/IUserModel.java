package com.riwi.library.infrastructure.IModels;

import com.riwi.library.infrastructure.dto.request.userRequestDtos.UserCreateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserModel {

    ResponseEntity<?> create(@RequestBody UserCreateRequestDTO userCreateRequestDTO);
}
