package com.example.movieBE.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getAppInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.movieBE.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getAppInfo() {
        return new ApiInfoBuilder()
                .title("Service mall API")
                .description("Service mall API document")
                .build();
    }
}