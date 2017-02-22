package com.manish.spring.messaging.v21;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

import static com.manish.spring.messaging.MessagingDetail.Bert_To_V21_Activation_Request;

@Component
public class V21ActivationRequestListener {

    private static final Logger LOG = LoggerFactory.getLogger(V21ActivationRequestListener.class);

    @Autowired
    private V21ActivationResponseSender v21ActivationResponseSender;

    @JmsListener(destination = Bert_To_V21_Activation_Request)
    public void receiveMessage(final Message message) throws JMSException {
        LOG.info("Step 2 : Msg Received  by V21 : "+ message.getPayload().toString());
        v21ActivationResponseSender.sendMessage(" Bert_To_V21_Activation_Request : " + message.getPayload().toString());
    }
}