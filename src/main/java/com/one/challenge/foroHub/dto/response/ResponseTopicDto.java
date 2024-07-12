package com.one.challenge.foroHub.dto.response;

import com.one.challenge.foroHub.domain.Topic;

import java.time.LocalDateTime;

public record ResponseTopicDto(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt) {

    public ResponseTopicDto(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreatedAt());
    }
}
