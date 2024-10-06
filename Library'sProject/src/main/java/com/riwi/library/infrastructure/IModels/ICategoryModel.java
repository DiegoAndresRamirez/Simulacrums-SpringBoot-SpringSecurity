package com.riwi.library.infrastructure.IModels;

import org.springframework.http.ResponseEntity;

public interface ICategoryModel {

    ResponseEntity<?> create(String name, String description);
}
