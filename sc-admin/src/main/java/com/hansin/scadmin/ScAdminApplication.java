package com.hansin.scadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class ScAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScAdminApplication.class, args);
    }

}
