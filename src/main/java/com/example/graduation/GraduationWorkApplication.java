package com.example.graduation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class GraduationWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationWorkApplication.class, args);
    }

}