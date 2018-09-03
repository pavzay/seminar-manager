package com.github.pavzay.seminarmanager.seminar.service;

import com.github.pavzay.seminarmanager.seminar.domain.Seminar;
import com.github.pavzay.seminarmanager.seminar.repository.SeminarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultSeminarService implements SeminarService {

    private final SeminarRepository repository;

    @Override
    public List<Seminar> findAll() {
        return repository.findAll();
    }

    @Override
    public Seminar create(Seminar seminar) {
        return repository.save(seminar);
    }
}
