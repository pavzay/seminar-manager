package com.github.pavzay.seminarmanager.repository;

import com.github.pavzay.seminarmanager.domain.Seminar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeminarRepository extends MongoRepository<Seminar, String> {
}
