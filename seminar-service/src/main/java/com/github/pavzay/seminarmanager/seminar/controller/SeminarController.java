package com.github.pavzay.seminarmanager.seminar.controller;

import com.github.pavzay.seminarmanager.seminar.domain.Seminar;
import com.github.pavzay.seminarmanager.seminar.repository.SeminarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class SeminarController {

    private final SeminarRepository seminarRepository;


    @GetMapping("/current")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    @GetMapping("save")
    public Seminar save() {
        Seminar seminar = new Seminar();
        seminar.setDescription("description");
        seminar.setLocation("location");
        seminar.setSpeaker("speaker");
        seminar.setTopic("topic");
        seminar.setStartDate(LocalDateTime.now());
        seminar.setEndDate(LocalDateTime.now());

        seminarRepository.save(seminar);
        System.out.println(seminar);


        System.out.println(seminarRepository.findById(seminar.getId()));
        System.out.println(seminarRepository.findById(seminar.getId()).get());

        return seminar;

    }
}
