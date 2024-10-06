package com.riwi.library.infrastructure.controllers;

import com.riwi.library.application.services.AutorService;
import com.riwi.library.infrastructure.IModels.IAutorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController implements IAutorModel {

    @Autowired
    private AutorService autorService;

    @Override
    public ResponseEntity<?> create(String name, String surname, String age, String description) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(autorService.create(name, surname, age, description));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
