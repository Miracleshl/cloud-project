package com.miracle.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Defination
 * Simple Class description.
 *
 * @author SHL
 * @version 1.0
 * @date 2020/9/4
 **/
@Configuration
public class DefinationConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
