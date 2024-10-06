package com.riwi.library.infrastructure.controllers;

import com.riwi.library.application.services.BookService;
import com.riwi.library.infrastructure.IModels.IBookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
public class BookController implements IBookModel {

    @Autowired
    private BookService bookService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> create(String title, String author, String year, String description) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(title, author, year, description));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
