package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"org.example.common","org.example.dao","org.example.entity","org.example.service"})
public class StudentClient {
    public static void main(String[] args) {
        SpringApplication.run(StudentClient.class,args);
    }
}