package com.cadencia.api.services;

import com.cadencia.api.dtos.UserRequestDTO;
import com.cadencia.api.entities.User;
import com.cadencia.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(UserRequestDTO data) {
        User newUser = new User();

        newUser.setName(data.name());
        newUser.setEmail(data.email());
        newUser.setPassword(data.password());

        newUser.setXp(0);

        return repository.save(newUser);
    }
}
