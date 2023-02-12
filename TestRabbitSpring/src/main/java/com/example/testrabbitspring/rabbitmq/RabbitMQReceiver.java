package com.example.testrabbitspring.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableRabbit
@Component
public class RabbitMQReceiver {


    @RabbitListener(queues = "Ground Control")
    public void worker1(String message) {
        log.info("accepted on Ground Control : " + message);
    }

//    @RabbitListener(queues = "globalExchange")
//    public void worker2(String message) {
//        log.info("accepted on globalExchange : " + message);
//    }


}