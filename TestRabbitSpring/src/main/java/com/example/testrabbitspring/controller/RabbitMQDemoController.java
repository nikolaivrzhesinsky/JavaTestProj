package com.example.testrabbitspring.controller;

import com.example.testrabbitspring.MenuOrder;
import com.example.testrabbitspring.rabbitmq.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQDemoController {
    @Autowired
    RabbitMQSender rabbitMQSender;

    @PostMapping(value = "/sender")
    public String producer(@RequestBody MenuOrder menuOrder) {
        rabbitMQSender.send(menuOrder);
        return "Message sent to the RabbitMQ Queue Successfully";
    }
}
