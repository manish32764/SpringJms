package com.manish.spring.messaging.v21;

import com.manish.spring.messaging.MessagingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class V21ActivationResponseSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final String textMessage) {

        jmsTemplate.send(MessagingDetail.V21_to_Bert_Activation_Response, new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(" V21_to_Bert_Activation_Response : " + textMessage);
                return textMessage;
            }
        });
    }
}
