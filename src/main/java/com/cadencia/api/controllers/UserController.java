package com.cadencia.api.controllers;

import com.cadencia.api.dtos.UserRequestDTO;
import com.cadencia.api.entities.User;
import com.cadencia.api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserRequestDTO data) {

        User createdUser = service.create(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

}
