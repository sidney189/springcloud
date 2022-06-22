package com.example.eurekaserver01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaserver01Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaserver01Application.class, args);
    }

}
