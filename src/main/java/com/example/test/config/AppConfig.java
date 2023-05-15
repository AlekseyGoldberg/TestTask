package com.example.test.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentSkipListSet;

@Configuration
@Getter
public class AppConfig {
    @Value("${app.filePath}")
    private String path;

    @Bean
    ConcurrentSkipListSet<Long> getSet() {
        return new ConcurrentSkipListSet<>();
    }
}
