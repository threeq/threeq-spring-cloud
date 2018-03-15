package me.threeq.boot.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2017/5/2
 * @User three
 */
//@Configuration
public class RabbitConfigure {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitConfigure.class);
//
//    @Value("${app.rabbitmq.host:localhost}")
//    String rabbitMqHost;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        LOG.info("Create RabbitMqCF for host: {}", rabbitMqHost);
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitMqHost);
//        return connectionFactory;
//    }

}
