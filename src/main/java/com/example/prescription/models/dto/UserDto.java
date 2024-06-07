package com.example.prescription.models.dto;

import jakarta.validation.constraints.NotNull;

public record UserDto(Long id,
                      @NotNull(message = "Name not be null") String firstName,
                      @NotNull(message = "Name not be null") String lastName,
                      @NotNull(message = "Email not be null") String email,
                      String password,
                      RoleEnum role) {
}