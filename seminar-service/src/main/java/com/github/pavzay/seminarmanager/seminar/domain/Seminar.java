package com.github.pavzay.seminarmanager.seminar.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Seminar {
    @Id
    private String id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String topic;
    private String description;
    private String location;
    private String speaker;
}
