package com.miracle.producter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Producter2Application {

    public static void main(String[] args) {
        SpringApplication.run(Producter2Application.class, args);
    }

}
