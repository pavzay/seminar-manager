package com.github.pavzay.seminarmanager.speaker.controller;

import com.github.pavzay.seminarmanager.speaker.domain.Speaker;
import com.github.pavzay.seminarmanager.speaker.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/speakers")
public class SpeakerController {

    private final SpeakerService speakerService;

    @GetMapping
    public List<Speaker> findAll() {
        return speakerService.findAll();
    }

    @GetMapping("/{name}")
    public Speaker findByName(@PathVariable String name) {
        return speakerService.findByName(name);
    }

    @PostMapping
    public Speaker create(@Valid @RequestBody Speaker speaker) {
        System.out.println(speaker);
        return speakerService.create(speaker);
    }

}
