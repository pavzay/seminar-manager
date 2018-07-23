package com.github.pavzay.seminarmanager.auth.service;

import com.github.pavzay.seminarmanager.auth.domain.User;
import com.github.pavzay.seminarmanager.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service("userDetailsService")
public class DatabaseUserService implements UserService {

    private static final BCryptPasswordEncoder B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public void create(User user) {
        if (userRepository.findById(user.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists: " + user.getUsername());
        }

        user.setPassword(B_CRYPT_PASSWORD_ENCODER.encode(user.getPassword()));

        userRepository.save(user);

        log.info("New user has been created: {}", user.getUsername());
    }
}
