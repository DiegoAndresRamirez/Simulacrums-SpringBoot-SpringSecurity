package com.events.riwi.infrastructure.controllers;

import com.events.riwi.application.services.UserService;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateRequestDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserCreateResponseDTO;
import com.events.riwi.infrastructure.dto.userDtos.UserGetResponseDTO;
import com.events.riwi.infrastructure.interfaces.IUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<UserCreateResponseDTO> createUser(@RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        try{
            UserCreateResponseDTO userCreateResponseDTO = userService.createUser(userCreateRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(userCreateResponseDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserGetResponseDTO> getUserById(@RequestParam Long id) {
        try{
            UserGetResponseDTO userGetResponseDTO = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(userGetResponseDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestParam Long id, @RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, userCreateRequestDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<UserGetResponseDTO>> getAllUsers() {
        try{
            List<UserGetResponseDTO> users = userService.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
