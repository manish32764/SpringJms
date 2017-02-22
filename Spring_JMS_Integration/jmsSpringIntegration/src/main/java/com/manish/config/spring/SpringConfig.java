package com.manish.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value = "com.*")
@EnableTransactionManagement
@Import(MessagingConfiguration.class)
public class SpringConfig {


}
