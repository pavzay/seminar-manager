package com.github.pavzay.seminarmanager.speaker.client;

import com.github.pavzay.seminarmanager.speaker.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("auth-service")
public interface AuthServiceClient {

    @PostMapping("/users")
    void createUser(User user);

}
