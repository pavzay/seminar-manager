package com.github.pavzay.seminarmanager.auth.repository;

import com.github.pavzay.seminarmanager.auth.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveAndFindUserByUsername() {
        User user = new User("username", "password");

        userRepository.save(user);
        Optional<User> foundUser = userRepository.findById("username");

        assertTrue(foundUser.isPresent());
        assertEquals(user, foundUser.get());
    }

}
