package com.manish.jms.sender;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final Order order) {
        jmsTemplate.send(new MessageCreator(){
            public Message createMessage(Session session) throws JMSException{
                ObjectMessage objectMessage = session.createObjectMessage(order);
                return objectMessage;
            }
        });
    }

}
