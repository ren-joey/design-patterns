package com.delta.dms.robotplatform.listener;

import com.delta.dms.robotplatform.service.MQService;
import com.delta.set.utils.LogUtil;
import lombok.Getter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private final MQService mqService;
    private final LogUtil log = LogUtil.getInstance();

    @Getter
    private final CountDownLatch latch = new CountDownLatch(1);

    public Receiver(MQService mqService) {
        this.mqService = mqService;
    }

    /**
     * This method is invoked by MessageListenerAdapter for processing incoming messages.
     */
    @SuppressWarnings("unused")
    public void receiveMessage(byte[] message) {
        String messageStr = new String(message, StandardCharsets.UTF_8);
        // fixme: remove log printing program
        System.out.println("Received message: " + messageStr);
        System.out.println("Received <" + messageStr + ">");
        mqService.analyzeMessage(messageStr);
        latch.countDown();
    }
}