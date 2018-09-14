package com.github.pavzay.seminarmanager.auth.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@RequiredArgsConstructor
@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final Environment env;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // @formatter:off
        clients.inMemory()
            .withClient("ui")
            .secret("{noop}ui")
            .authorizedGrantTypes("refresh_token", "password")
            .scopes("ui")
         .and()
            .withClient("seminar-service")
            .secret("{noop}" + env.getProperty("SEMINAR_SERVICE_PASSWORD"))
            .authorizedGrantTypes("client_credentials", "refresh_token")
            .scopes("server")
         .and()
            .withClient("speaker-service")
            .secret("{noop}" + env.getProperty("SPEAKER_SERVICE_PASSWORD"))
            .authorizedGrantTypes("client_credentials", "refresh_token")
            .scopes("server")
        ;
        // @formatter:on
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .tokenStore(new InMemoryTokenStore())
            .authenticationManager(authenticationManager);
    }

}
