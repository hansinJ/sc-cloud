package com.hansin.sctech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hansin"})
public class ScTechApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScTechApplication.class, args);
    }

}
