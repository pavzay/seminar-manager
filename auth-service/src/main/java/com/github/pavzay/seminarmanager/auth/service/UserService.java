package com.github.pavzay.seminarmanager.auth.service;

import com.github.pavzay.seminarmanager.auth.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void create(User user);
}
