package com.riwi.library.infrastructure.IModels;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAutorModel {

    ResponseEntity<?> create(@RequestBody String name, @RequestBody String surname, @RequestBody String age, @RequestBody String description);
}
