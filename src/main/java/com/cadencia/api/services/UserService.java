package com.cadencia.api.services;

import com.cadencia.api.dtos.UserRequestDTO;
import com.cadencia.api.entities.User;
import com.cadencia.api.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(UserRequestDTO data) {
        if (repository.existsByName(data.name())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This username is already in use.");
        }

        if (repository.existsByEmail(data.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This email is already in use.");
        }

        User newUser = new User();

        newUser.setName(data.name());
        newUser.setEmail(data.email());
        newUser.setPassword(passwordEncoder.encode(data.password()));

        newUser.setXp(0);

        return repository.save(newUser);
    }
}
