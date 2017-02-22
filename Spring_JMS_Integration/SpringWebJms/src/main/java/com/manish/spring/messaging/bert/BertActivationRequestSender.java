package com.manish.spring.messaging.bert;

import com.manish.spring.messaging.MessagingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class BertActivationRequestSender {


    public BertActivationRequestSender() {
        System.out.println("Inside Constructor BertActivationRequestSender");
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final String messageText) {

        jmsTemplate.send(MessagingDetail.Bert_To_V21_Activation_Request, new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(" Bert_To_V21_Activation_Request : " + messageText);
                return textMessage;
            }
        });
    }
}
