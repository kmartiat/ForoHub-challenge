package com.one.challenge.foroHub.controller;

import com.one.challenge.foroHub.domain.Topic;
import com.one.challenge.foroHub.dto.request.RequestTopicDto;
import com.one.challenge.foroHub.dto.response.ResponseTopicDto;
import com.one.challenge.foroHub.repository.ITopicRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/topics")
public class TopicController {

    @Autowired
    ITopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseTopicDto> saveTopic(@RequestBody @Valid RequestTopicDto request,
                                                      UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = repository.save(new Topic(request));
        URI uri = uriComponentsBuilder.path("/api/v1/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseTopicDto(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTopicDto> gerTopicById(@PathVariable Long id) {
        Optional<Topic> topic = repository.findById(id);
        if (topic.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok(new ResponseTopicDto(topic.get()));
    }

    @GetMapping()
    public ResponseEntity<Page<ResponseTopicDto>> getAllTopics(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable).map(ResponseTopicDto::new));
    }
}
