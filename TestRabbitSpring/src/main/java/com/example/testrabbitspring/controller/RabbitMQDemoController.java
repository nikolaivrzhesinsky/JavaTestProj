package com.example.testrabbitspring.controller;

import com.example.testrabbitspring.rabbitmq.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQDemoController {

    private final RabbitMQSender rabbitMQSender;

    @Autowired
    public RabbitMQDemoController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping(value = "/sender")
    public String producer() {
        rabbitMQSender.send();
        return "Message sent to the RabbitMQ Queue Successfully";
    }

    @PostMapping(value = "/sender_gl")
    public String producer_gl() {
        rabbitMQSender.sendGlobal();
        return "Message sent to the RabbitMQ Queue Successfully";
    }

}
