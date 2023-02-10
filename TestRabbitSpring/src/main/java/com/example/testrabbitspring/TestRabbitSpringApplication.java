package com.example.testrabbitspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class})
public class TestRabbitSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRabbitSpringApplication.class, args);
    }

}
