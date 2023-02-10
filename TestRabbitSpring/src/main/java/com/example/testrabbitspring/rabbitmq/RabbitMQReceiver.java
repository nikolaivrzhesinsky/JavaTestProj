package com.example.testrabbitspring.rabbitmq;

import com.example.testrabbitspring.MenuOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQReceiver {

    @RabbitHandler
    @RabbitListener(queues = {"rabbitmq.queue"})
    public void receiver(MenuOrder menuOrder) {
        log.info("MenuOrder listener invoked - Consuming Message with MenuOrder Identifier : "
                + menuOrder.getOrderIdentifier());
    }
}