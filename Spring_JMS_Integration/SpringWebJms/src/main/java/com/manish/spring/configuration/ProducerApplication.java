package com.manish.spring.configuration;

import java.util.concurrent.atomic.AtomicInteger;

import com.manish.spring.messaging.pacs.PacsMliRequestSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ProducerApplication {

	static final Logger LOG = LoggerFactory.getLogger(ProducerApplication.class);
	
	private static AtomicInteger id = new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PacsMliRequestSender pacsMliRequestSender =context.getBean(PacsMliRequestSender.class);
        pacsMliRequestSender.sendMessage(" Manish ");

        Thread.sleep(1000 * 60 * 3);
	}
}
