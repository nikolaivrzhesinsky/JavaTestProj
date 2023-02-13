package com.example.testrabbitspring.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.setExchange("Ground Control");
        rabbitTemplate.convertAndSend("Ground Control");
        log.info("Sending Message to the GroundExchange : Ground Control");
    }

    public void sendGlobal() {
        rabbitTemplate.setExchange("global");
        rabbitTemplate.convertAndSend("Global");
        log.info("Sending Message to the Global : Global");
    }

    public void sendHelloToServer() throws InterruptedException {

        String responseHello = "";
        rabbitTemplate.setExchange("global");
        log.info("Send Hello message to Global");

        while (responseHello == (String) rabbitTemplate.convertSendAndReceive("Ground Control")) {

            log.warn("Didnt get the response");
            Thread.sleep(1000);
        }
        log.info("Server is ready for work");
    }


}
