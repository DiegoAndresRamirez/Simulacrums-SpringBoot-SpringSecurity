package com.riwi.library.infrastructure.IModels;

import org.springframework.http.ResponseEntity;

public interface IUserModel {

    ResponseEntity<?> create(String name, String surname, String email, String password, String role);
}
