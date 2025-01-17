package com.ust.laptop_budget.Config;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import  jakarta.persistence.*;

@Configuration
public class JpaStreamerConfig {

    @Bean
    public JPAStreamer jpaStreamer(EntityManagerFactory entityManagerFactory) {
        return JPAStreamer.of(entityManagerFactory);
    }
}