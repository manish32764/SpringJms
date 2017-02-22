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
public class BertMliRequestListener {

    @Autowired
    private BertActivationRequestSender bertActivationRequestSender;

    private static final Logger LOG = LoggerFactory.getLogger(BertMliRequestListener.class);

    @JmsListener(destination = MessagingDetail.Pacs_To_Bert_Mli_Request)
    public void receiveMessage(final Message message) throws JMSException {
        final String data = message.getPayload().toString();
        LOG.info("Step 1 : Msg Received  by Bert : "+ data);
        bertActivationRequestSender.sendMessage(" Pacs_To_Bert_Mli_Request : " + data);
    }
}
