package com.one.challenge.foroHub.controller;

import com.one.challenge.foroHub.domain.Topic;
import com.one.challenge.foroHub.dto.request.RequestTopicDto;
import com.one.challenge.foroHub.dto.response.ResponseTopicDto;
import com.one.challenge.foroHub.repository.ITopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
}
