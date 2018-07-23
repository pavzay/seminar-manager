package com.github.pavzay.seminarmanager.auth.service;

import com.github.pavzay.seminarmanager.auth.domain.User;
import com.github.pavzay.seminarmanager.auth.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class DatabaseUserServiceTest {

    @InjectMocks
    private DatabaseUserService service;

    @Mock
    private UserRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldLoadByUsernameWhenUserExists() {
        User user = new User("username", "password");
        when(repository.findById("username")).thenReturn(Optional.of(user));

        UserDetails loadedUser = service.loadUserByUsername("username");

        assertEquals(user, loadedUser);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void shouldFailLoadByUsernameWhenUserNotExists() {
        service.loadUserByUsername("username");
    }

    @Test
    public void shouldCreateUser() {
        User user = new User("username", "password");

        service.create(user);

        verify(repository, times(1)).save(user);
    }

    @Test(expected = RuntimeException.class)
    public void shouldFailCreationWhenUserAlreadyExists() {
        User user = new User("username", "password");
        when(repository.findById("username")).thenReturn(Optional.of(user));

        service.create(user);
    }

}
