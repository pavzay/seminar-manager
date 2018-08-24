package com.github.pavzay.seminarmanager.speaker.repository;

import com.github.pavzay.seminarmanager.speaker.domain.Speaker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpeakerRepository extends MongoRepository<Speaker, String> {
}
