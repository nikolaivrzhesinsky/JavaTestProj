package com.example.testrabbitspring.rabbitmq;

import com.example.testrabbitspring.MenuOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Exchange exchange;
    @Autowired
    private Queue queue;

    public void send(MenuOrder menuOrder) {
        rabbitTemplate.convertAndSend(exchange.getName(), menuOrder);
        log.info("Sending Message to the Queue : " + menuOrder.toString());
    }

//    public void send(MenuOrder menuOrder) {
//        rabbitTemplate.convertAndSend(queue.getName(), menuOrder);
//        log.info("Sending Message to the Queue : " + menuOrder.toString());
//    }
}
