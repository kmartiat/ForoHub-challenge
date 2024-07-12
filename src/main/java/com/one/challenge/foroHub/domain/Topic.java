package com.one.challenge.foroHub.domain;


import com.one.challenge.foroHub.dto.request.RequestTopicDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(unique = true)
    private String message;

    private String author;
    private String course;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Topic(RequestTopicDto request) {
        this.title = request.title();
        this.message = request.message();
        this.author = request.author();
        this.course = request.course();
    }
}
