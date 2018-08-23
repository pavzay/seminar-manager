package com.github.pavzay.seminarmanager.seminar.repository;

import com.github.pavzay.seminarmanager.seminar.domain.Seminar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarRepositoryTest {

    @Autowired
    private SeminarRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Seminar testSeminar;

    @Before
    public void setUp() {
        testSeminar = Seminar.builder()
            .id("testId")
            .startDate(LocalDateTime.of(2018, Month.JANUARY, 1, 10, 0))
            .endDate(LocalDateTime.of(2018, Month.JANUARY, 1, 11, 0))
            .description("testDescription")
            .location("testLocation")
            .speaker("testSpeaker")
            .topic("testTopic")
            .build();
        mongoTemplate.save(testSeminar);
    }


    @Test
    public void shouldReturnSeminarById() {
        Optional<Seminar> foundSeminar = repository.findById("testId");

        assertTrue(foundSeminar.isPresent());
        assertThat(foundSeminar.get(), equalTo(testSeminar));
    }

    @Test
    public void shouldReturnAllSeminars() {
        List<Seminar> foundSeminars = repository.findAll();

        assertThat(foundSeminars, hasSize(1));
    }

    @Test
    public void shouldDeleteSeminarById() {
        repository.deleteById("testId");

        assertThat(mongoTemplate.findById("testId", Seminar.class), equalTo(null));
    }

    @Test
    public void shouldCreateNewSeminar() {
        Seminar newSeminar = Seminar.builder()
            .id("newSeminar")
            .build();

        repository.save(newSeminar);

        assertThat(mongoTemplate.findById("newSeminar", Seminar.class), equalTo(newSeminar));
    }

}
