package com.manish.service;

import com.manish.jms.sender.MessageSender;
import com.manish.vo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    public void sendProduct(Product product) {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        LOG.info("Application : sending order request {}", product);
       // messageSender.sendMessage(product);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
