package com.github.pavzay.seminarmanager.seminar.controller;

import com.github.pavzay.seminarmanager.seminar.domain.Seminar;
import com.github.pavzay.seminarmanager.seminar.service.SeminarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class SeminarController {

    private final SeminarService seminarService;

    @GetMapping
    public List<Seminar> findAll() {
        return seminarService.findAll();
    }

    @PostMapping
    public Seminar create(@Valid @RequestBody Seminar seminar) {
        return seminarService.create(seminar);
    }
}
