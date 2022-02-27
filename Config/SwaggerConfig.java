package com.couponsProject.project2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * configuration class to set-up swagger
 */
@Configuration
@EnableSwagger2

public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2) //return information in swagger 2 format
                .select() //select the documentation type
                .apis(RequestHandlerSelectors.any()) //use any selectors
                .paths(PathSelectors.any())          //use any path
                .build();                            //build our shiny new swagger
    }
}
