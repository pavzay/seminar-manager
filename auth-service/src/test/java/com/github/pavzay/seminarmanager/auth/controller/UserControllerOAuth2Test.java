package com.github.pavzay.seminarmanager.auth.controller;

import com.github.pavzay.seminarmanager.auth.domain.User;
import com.github.pavzay.seminarmanager.auth.service.UserService;
import com.sun.jersey.core.util.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerOAuth2Test {

    private static final JacksonJsonParser JSON_PARSER = new JacksonJsonParser();

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserService userService;

    private String host;

    @Before
    public void setUp() {
        host = "http://localhost:" + port + "/";
    }

    @Test
    public void shouldReturnCurrentUser() {
        ResponseEntity<String> responseEntity = restTemplate.exchange(host + "/users/current", HttpMethod.GET, prepareRequestEntity(), String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        String username = JSON_PARSER.parseMap(responseEntity.getBody()).get("name").toString();
        assertEquals("testUser", username);
    }

    @Test
    public void shouldReturnUnauthorizedStatusWhenTokenIsEmpty() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(host + "/users/current", String.class);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }

    private HttpEntity prepareRequestEntity() {
        createTestUser();
        String accessToken = obtainAccessToken();

        HttpHeaders headers = new HttpHeaders();
        setAuthorizationBearerHeader(headers, accessToken);
        return new HttpEntity<>("", headers);
    }

    private void createTestUser() {
        userService.create(new User("testUser", "testPassword"));
    }

    private String obtainAccessToken() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("scope", "ui");
        body.add("grant_type", "password");
        body.add("username", "testUser");
        body.add("password", "testPassword");

        HttpHeaders headers = new HttpHeaders();
        setAuthorizationBasicHeader(headers, "ui", "ui");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        String response = restTemplate.postForObject(host + "/oauth/token", requestEntity, String.class);

        return JSON_PARSER.parseMap(response).get("access_token").toString();
    }

    private void setAuthorizationBasicHeader(HttpHeaders httpHeaders, String username, String password) {
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encode(auth);
        String authHeader = "Basic " + new String(encodedAuth);
        httpHeaders.add(HttpHeaders.AUTHORIZATION, authHeader);
    }

    private void setAuthorizationBearerHeader(HttpHeaders httpHeaders, String token) {
        String authHeader = "Bearer " + token;
        httpHeaders.add(HttpHeaders.AUTHORIZATION, authHeader);
    }

}
