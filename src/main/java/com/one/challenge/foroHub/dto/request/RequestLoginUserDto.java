package com.one.challenge.foroHub.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestLoginUserDto(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
) {
}
