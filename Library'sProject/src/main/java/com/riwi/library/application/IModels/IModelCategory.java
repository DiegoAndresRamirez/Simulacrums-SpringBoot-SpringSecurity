package com.riwi.library.application.IModels;

import com.riwi.library.infrastructure.dto.request.categoryRequestDtos.CategoryCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.categoryResponseDtos.CategoryCreateResponseDTO;

public interface IModelCategory {

    CategoryCreateResponseDTO create(CategoryCreateRequestDTO categoryCreateRequestDTO);
}
