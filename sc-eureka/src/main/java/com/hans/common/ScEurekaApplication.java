package com.hans.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ScEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScEurekaApplication.class, args);
    }

}
