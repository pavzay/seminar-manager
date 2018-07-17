package com.github.pavzay.seminarmanager.seminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SeminarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeminarApplication.class, args);
    }

}
