package com.one.challenge.foroHub.repository;

import com.one.challenge.foroHub.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicRepository extends JpaRepository<Topic, Long> {
}
