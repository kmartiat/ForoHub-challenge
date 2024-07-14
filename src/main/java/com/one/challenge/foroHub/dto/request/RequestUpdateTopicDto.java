package com.one.challenge.foroHub.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RequestUpdateTopicDto(
        String title,
        String message) {
}
