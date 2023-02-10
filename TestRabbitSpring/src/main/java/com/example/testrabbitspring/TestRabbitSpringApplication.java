package com.example.testrabbitspring;

import com.example.testrabbitspring.config.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication

public class TestRabbitSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRabbitSpringApplication.class, args);
    }

}
