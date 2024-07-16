package com.one.challenge.foroHub.controller;

import com.one.challenge.foroHub.domain.Topic;
import com.one.challenge.foroHub.domain.User;
import com.one.challenge.foroHub.dto.request.RequestTopicDto;
import com.one.challenge.foroHub.dto.request.RequestUpdateTopicDto;
import com.one.challenge.foroHub.dto.response.ResponseTopicDto;
import com.one.challenge.foroHub.repository.ITopicRepository;
import com.one.challenge.foroHub.repository.IUserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    @Autowired
    ITopicRepository repository;

    @Autowired
    IUserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseTopicDto> saveTopic(@RequestBody @Valid RequestTopicDto request,
                                                      UriComponentsBuilder uriComponentsBuilder) {
        Optional<User> user = userRepository.findById(request.authorId());
        if (user.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Topic topic = repository.save(new Topic(request, user.get()));
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseTopicDto> updateTopic(@PathVariable Long id, @RequestBody RequestUpdateTopicDto body) {
        Optional<Topic> topic = repository.findById(id);
        if (topic.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok(new ResponseTopicDto(topic.get().updateData(body)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        Optional<Topic> topic = repository.findById(id);
        if (topic.isEmpty()) {
            throw new EntityNotFoundException();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
