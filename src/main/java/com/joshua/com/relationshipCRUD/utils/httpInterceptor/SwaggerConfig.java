package com.joshua.com.relationshipCRUD.utils.httpInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiInfo apiInfo() {
        return new ApiInfo("E&M SACCO SOLUTION",
                "Comprehensive SAcco SOlution.",
                "1.0",
                "Terms of service",
                new Contact("E&M", "www.emtechhouse.co.ke", "developer@emtechhouse.co.ke"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .apiInfo(apiInfo())
                .globalRequestParameters(Arrays.asList(new RequestParameterBuilder().name("userName")
                        .description("Remote User").in(ParameterType.HEADER).required(true)
                        .query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder
                                .allowEmptyValue(false).model(modelSpecificationBuilder -> modelSpecificationBuilder
                                        .scalarModel(ScalarType.STRING)))
                        .build())).globalRequestParameters(Arrays.asList(new RequestParameterBuilder().name("entityId")
                        .description("Entity ID").in(ParameterType.HEADER).required(true)
                        .query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder
                                .allowEmptyValue(false).model(modelSpecificationBuilder -> modelSpecificationBuilder
                                        .scalarModel(ScalarType.STRING)))
                        .build()));
    }
}
