package com.riwi.library.infrastructure.controllers;

import com.riwi.library.application.services.UserService;
import com.riwi.library.infrastructure.IModels.IUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController implements IUserModel {

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> create(String name, String surname, String email, String password, String role) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(name, surname, email, password, role));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
