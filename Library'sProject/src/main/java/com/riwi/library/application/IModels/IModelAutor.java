package com.riwi.library.application.IModels;

import com.riwi.library.infrastructure.dto.request.AutorCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.AutorCreateResponseDTO;

public interface IModelAutor {
    AutorCreateResponseDTO create(AutorCreateRequestDTO autorCreateRequestDTO);
}
