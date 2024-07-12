package com.one.challenge.foroHub.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RequestTopicDto(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        String author,
        @NotBlank
        String course) {
}
