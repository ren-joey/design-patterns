package com.delta.dms.robotplatform.utils.app;

import com.delta.set.utils.LogUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class MQManager {
    private static final LogUtil log = LogUtil.getInstance();

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String DEFAULT_EXCHANGE = "";
    private static final String ARG_MAX_PRIORITY = "x-max-priority";
    private static final int RETRY_TIMES = 3;
    private static final int RETRY_INTERVAL = 2; // seconds
    private static final int QUEUE_MAX_PRIORITY = 5;
    private static final int MESSAGE_PRIORITY = 3;

    private final ConnectionFactory factory;
    private final String queueName;
    private final BasicProperties defaultMsgProperties;
    private final Map<String, Object> queueArgs = new HashMap<>();

    private Connection connection;
    private Channel channel;

    public MQManager(String queueName, String userName, String password,
                     String virtualHost, String host, int port) {
        this.queueName = queueName;
        // set connect parameters
        factory = new ConnectionFactory();
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setHost(host);
        factory.setPort(port);

        // set msg priority
        BasicProperties.Builder builder = new BasicProperties.Builder();
        builder.priority(MESSAGE_PRIORITY);
        this.defaultMsgProperties = builder.build();

        //set queue args
        this.queueArgs.put(ARG_MAX_PRIORITY, QUEUE_MAX_PRIORITY);
    }

    public String getMessage() {
        // fetch message from MQ
        try {
            Channel channel = createQueue(queueName);
            GetResponse getResponse = channel.basicGet(queueName, true);
            if (null != getResponse) {
                String message = new String(getResponse.getBody(), StandardCharsets.UTF_8);
                BasicProperties msgProps = getResponse.getProps();
                log.info(String.format("%s get MQ message: %s, priority: %d", queueName, message, msgProps.getPriority()));
                return message;
            } else {
                return null;
            }
        } catch (IOException e) {
            log.error(String.format("Get MQ message failed: %s", e.getMessage()));
            return null;
        } catch (TimeoutException e) {
            log.error(String.format("Timeout for getting message: %s", e.getMessage()));
            return null;
        }
    }

    public Channel createQueue(String queueName) throws IOException, TimeoutException {
        try {
            getConnection();
            channel.queueDeclare(queueName, true, false, false, queueArgs);
        } catch (IOException e) {
            getConnection();
            channel.queueDeclare(queueName, true, false, false, null);
        }
        return channel;
    }

    public void close() {
        try {
            if (connection.isOpen()) {
                connection.close();
            }
        } catch (IOException e) {
            log.error(String.format("Close Connection failed: %s", e.getMessage()));
        }
    }

    private void getConnection() throws IOException, TimeoutException {
        if (null == channel || !channel.isOpen()) {
            if (null == connection || !connection.isOpen()) {
                connection = factory.newConnection();
            }
            channel = connection.createChannel();
        }
    }

    private boolean sendMessage(String queueName, String eventMsg,
                                BasicProperties msgProps) {
        if (null == msgProps.getPriority()) {
            msgProps = defaultMsgProperties;
        }
        for (int retry = 1; retry <= RETRY_TIMES; retry++) {
            try {
                Channel channel = createQueue(queueName);
                byte[] jsonBytes = mapper.writeValueAsBytes(eventMsg);
                channel.basicPublish(DEFAULT_EXCHANGE, queueName, msgProps, jsonBytes);
                // write msg log : queueName, jsonMsg
                log.info(String.format("Send to: %s, msg %s, msgPriority %d.", queueName, eventMsg, msgProps.getPriority()));
                return true;
            } catch (IOException e) {
                log.error(String.format("Send MQ message to Event failed. Retry: (%d) %s", retry, e.getMessage()));
            } catch (TimeoutException e) {
                log.error(String.format("Timeout for sending message to Event. Retry: (%d) %s", retry, e.getMessage()));
            }
            try {
                Thread.sleep(RETRY_INTERVAL * 1000);
            } catch (InterruptedException e) {
                log.warn("Task interrupted, exit.");
                return false;
            }
        }
        return false;
    }
}
