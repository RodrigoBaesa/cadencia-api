package com.cadencia.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "Username can't be empty.")
        @Size(min = 4, max = 16, message = "Username must be between 4 and 16 characters.")
        String name,

        @NotBlank(message = "Email can't be empty.")
        @Email(message = "Email invalid format. ")
        String email,

        @NotBlank(message = "Password can't be empty.")
        @Size(min = 8, message = "Password must have at least 8 characters.")
        String password) {
}
