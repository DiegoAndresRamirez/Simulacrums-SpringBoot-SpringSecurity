package com.riwi.library.infrastructure.controllers;

import com.riwi.library.application.services.CategoryService;
import com.riwi.library.infrastructure.IModels.ICategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController implements ICategoryModel {

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<?> create(String name, String description) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(name, description));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
