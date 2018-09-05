package com.github.pavzay.seminarmanager.gateway.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private final ZuulProperties zuulProperties;

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(getApiInfo())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
            .title("Seminar Manager")
            .build();
    }

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>();

            zuulProperties.getRoutes().forEach((serviceId, route) -> {
                SwaggerResource swaggerResource = new SwaggerResource();
                swaggerResource.setName(serviceId);
                swaggerResource.setLocation(route.getPath().replace("/**", "") + "/v2/api-docs");
                swaggerResource.setSwaggerVersion("2.0");
                resources.add(swaggerResource);
            });

            return resources;
        };
    }

}

