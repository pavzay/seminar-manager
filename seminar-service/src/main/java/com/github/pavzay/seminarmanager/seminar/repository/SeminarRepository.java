package com.github.pavzay.seminarmanager.seminar.repository;

import com.github.pavzay.seminarmanager.seminar.domain.Seminar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeminarRepository extends MongoRepository<Seminar, String> {
}
