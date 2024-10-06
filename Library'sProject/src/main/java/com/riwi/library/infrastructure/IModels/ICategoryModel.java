package com.riwi.library.infrastructure.IModels;

import com.riwi.library.infrastructure.dto.request.categoryRequestDtos.CategoryCreateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICategoryModel {

    ResponseEntity<?> create(@RequestBody CategoryCreateRequestDTO categoryCreateRequestDTO);
}
