package com.riwi.library.infrastructure.IModels;

import com.riwi.library.infrastructure.dto.request.autorRequestDtos.AutorCreateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAutorModel {

    ResponseEntity<?> create(@RequestBody AutorCreateRequestDTO autorCreateRequestDTO);
}
