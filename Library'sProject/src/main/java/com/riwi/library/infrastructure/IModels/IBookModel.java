package com.riwi.library.infrastructure.IModels;

import org.springframework.http.ResponseEntity;

public interface IBookModel {

    ResponseEntity<?> create(String title, String author, String year, String description);
}
