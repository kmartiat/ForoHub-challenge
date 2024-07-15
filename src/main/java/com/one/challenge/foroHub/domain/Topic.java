package com.one.challenge.foroHub.domain;


import com.one.challenge.foroHub.dto.request.RequestTopicDto;
import com.one.challenge.foroHub.dto.request.RequestUpdateTopicDto;
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

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    private String course;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Topic(RequestTopicDto request, User user) {
        this.title = request.title();
        this.message = request.message();
        this.author = user;
        this.course = request.course();
    }

    public Topic(RequestTopicDto request) {
    }

    public Topic updateData(RequestUpdateTopicDto body) {
        if (body.title() != null) {
            this.title = body.title();
        }
        if (body.message() != null) {
            this.message = body.message();
        }
        return this;
    }
}
