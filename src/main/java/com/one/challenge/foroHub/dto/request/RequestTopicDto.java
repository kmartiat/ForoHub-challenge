package com.one.challenge.foroHub.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestTopicDto(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long authorId,
        @NotBlank
        String course) {
}
