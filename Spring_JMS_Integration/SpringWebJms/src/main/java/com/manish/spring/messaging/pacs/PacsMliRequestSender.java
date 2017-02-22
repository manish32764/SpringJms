package com.manish.spring.messaging.pacs;

import com.manish.spring.messaging.MessagingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class PacsMliRequestSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final String messageTExt) {

        jmsTemplate.send(MessagingDetail.Pacs_To_Bert_Mli_Request, new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(" Pacs_To_Bert_Mli_Request : " +messageTExt);
                return textMessage;
            }
        });
    }
}
