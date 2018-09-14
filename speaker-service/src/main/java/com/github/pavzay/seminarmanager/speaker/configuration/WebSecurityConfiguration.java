package com.github.pavzay.seminarmanager.speaker.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        //ignore security for swagger documentation, actuator and create user endpoint
        web
            .ignoring().antMatchers("/v2/api-docs", "/actuator/**").antMatchers(HttpMethod.POST, "/*");
    }
}
