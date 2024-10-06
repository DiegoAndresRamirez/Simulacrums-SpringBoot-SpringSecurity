package com.riwi.library.infrastructure.IModels;

import com.riwi.library.infrastructure.dto.request.bookRequestDtos.BookCreateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IBookModel {

    ResponseEntity<?> create(@RequestBody BookCreateRequestDTO bookCreateRequestDTO);
}
