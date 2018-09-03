package com.github.pavzay.seminarmanager.speaker.service;

import com.github.pavzay.seminarmanager.speaker.client.AuthServiceClient;
import com.github.pavzay.seminarmanager.speaker.domain.Speaker;
import com.github.pavzay.seminarmanager.speaker.domain.User;
import com.github.pavzay.seminarmanager.speaker.repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultSpeakerService implements SpeakerService {

    private final SpeakerRepository repository;

    private final AuthServiceClient authServiceClient;

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    @Override
    public Speaker findByName(String name) {
        return repository.findById(name).orElseThrow(RuntimeException::new);
    }

    @Override
    public Speaker create(Speaker speaker) {
        authServiceClient.createUser(new User(speaker.getName(), speaker.getPassword()));
        return repository.save(speaker);
    }

}
