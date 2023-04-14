package com.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscorevyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscorevyServerApplication.class, args);
    }

}
