package com.riwi.library.application.IModels;

import com.riwi.library.infrastructure.dto.request.bookRequestDtos.BookCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.bookResponseDtos.BookCreateResponseDTO;

public interface IModelBook {
    BookCreateResponseDTO create(BookCreateRequestDTO bookCreateRequestDTO);
}
