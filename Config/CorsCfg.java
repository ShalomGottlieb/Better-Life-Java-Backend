package com.couponsProject.project2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * configuration class to set-up servers and paths that will be allowed to reach data
 */

@Configuration
public class CorsCfg {
    @Bean
    public CorsFilter corsFilter(){
        //create new url configuration for browsers
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //create new cors configuration....
        CorsConfiguration config = new CorsConfiguration();
        //allow to get credentials in cors
        config.setAllowCredentials(false);
        //allow to get from any ip/domain
        config.addAllowedOrigin("localhost:3000");
        //allow to get any header
        config.addAllowedHeader("*");
        config.addExposedHeader("*");
        config.addAllowedOrigin("*");
        //allow to get methods
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        //allow to get any route -> localhost:8080/api/lecturer -> /api/lecture is route
        source.registerCorsConfiguration("/**",config);
        //return new configuration
        return new CorsFilter(source);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}

