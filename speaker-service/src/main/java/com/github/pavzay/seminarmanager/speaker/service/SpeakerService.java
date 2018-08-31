package com.github.pavzay.seminarmanager.speaker.service;

import com.github.pavzay.seminarmanager.speaker.domain.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> findAll();
    Speaker findByName(String name);
    Speaker create(Speaker speaker);
}
