package com.github.pavzay.seminarmanager.seminar.service;

import com.github.pavzay.seminarmanager.seminar.domain.Seminar;

import java.util.List;

public interface SeminarService {
    List<Seminar> findAll();
    Seminar create(Seminar seminar);
}
