package com.riwi.library.application.IModels;

import com.riwi.library.infrastructure.dto.request.autorRequestDtos.AutorCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.autorResponseDtos.AutorCreateResponseDTO;

public interface IModelAutor {
    AutorCreateResponseDTO create(AutorCreateRequestDTO autorCreateRequestDTO);
}
