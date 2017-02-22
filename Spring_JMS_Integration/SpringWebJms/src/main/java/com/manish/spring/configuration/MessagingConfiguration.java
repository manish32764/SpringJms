package com.manish.spring.configuration;

import java.util.Arrays;

import com.manish.spring.messaging.MessagingDetail;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfiguration {

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(MessagingDetail.DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.websystique.spring","java.util"));
		return connectionFactory;
	}
	
	@Bean 
	public JmsTemplate jmsTemplate(){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		return template;
	}
	
}
