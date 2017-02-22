package com.manish.spring.messaging.bert;

import com.manish.spring.messaging.MessagingDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class BertActivationResponseListener {

    private static final Logger LOG = LoggerFactory.getLogger(BertActivationResponseListener.class);

    @Autowired
    BertMliResponseSender bertMliResponseSender;

    @JmsListener(destination = MessagingDetail.V21_to_Bert_Activation_Response)
    public void receiveMessage(final Message message) throws JMSException {
        String data = message.getPayload().toString();
        LOG.info("Step 3 Msg Received from V21  : "+ data);
        bertMliResponseSender.sendMessage(" V21_to_Bert_Activation_Response : " + data);
    }
}
