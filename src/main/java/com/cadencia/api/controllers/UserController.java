package com.cadencia.api.controllers;

import com.cadencia.api.dtos.UserRequestDTO;
import com.cadencia.api.entities.User;
import com.cadencia.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserRequestDTO data) {

        User createdUser = service.create(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

}
