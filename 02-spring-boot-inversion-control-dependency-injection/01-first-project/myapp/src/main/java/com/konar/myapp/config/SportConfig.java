package com.konar.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.konar.myapp.common.Coach;
import com.konar.myapp.common.SwimCoach;

@Configuration
public class SportConfig {

    @Bean
    Coach swimCoach() {
        return new SwimCoach();
    }

}
