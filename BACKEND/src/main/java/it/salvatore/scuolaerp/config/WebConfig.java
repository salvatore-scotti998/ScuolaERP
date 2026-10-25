package it.salvatore.scuolaerp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // tutte le API
                        .allowedOrigins("http://localhost:4200") // consenti Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // tutti i metodi
                        .allowedHeaders("*"); // tutti gli header
                       // .allowCredentials(true); // se usi cookie/sessione
            }
        };
    }
}