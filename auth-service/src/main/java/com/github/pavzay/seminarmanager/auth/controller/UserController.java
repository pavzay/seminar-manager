package com.github.pavzay.seminarmanager.auth.controller;

import com.github.pavzay.seminarmanager.auth.domain.User;
import com.github.pavzay.seminarmanager.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PostMapping
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }
}
