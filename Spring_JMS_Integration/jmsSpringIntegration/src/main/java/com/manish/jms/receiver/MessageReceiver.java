package com.manish.jms.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

import static com.manish.config.JmsDetail.MLI_RESPONSE_QUEUE;

@Component
public class MessageReceiver {

    @JmsListener(destination = MLI_RESPONSE_QUEUE)
    public void receiveMessage(final Message message) throws JMSException {
        MessageHeaders headers =  message.getHeaders();
        System.out.println("Application : headers received : {}" + headers);
    }
}
