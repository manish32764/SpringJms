package com.manish.spring.messaging.pacs;

import com.manish.spring.messaging.MessagingDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class PacsMliResponseListener {

    private static final Logger LOG = LoggerFactory.getLogger(PacsMliResponseListener.class);

    @JmsListener(destination = MessagingDetail.Bert_To_Pacs_Mli_Response)
    public void receiveMessage(final Message message) throws JMSException {
        LOG.info("Step 4 : Msg Received  from Bert "+ message.getPayload().toString());
    }
}