package com.threeq.antnetwork.server.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2017/5/2
 * @User three
 */
@Configuration
public class RabbitConfigure {
    //private static final Logger LOG = LoggerFactory.getLogger(TurbineApp.class);
    @Value("${app.rabbitmq.host:localhost}")
    String rabbitMQHost;

    @Bean
    public ConnectionFactory connectionFactory() {
        //LOG.info("Creating RabbitMQHost ConnectionFactory for host: {}", rabbitMQHost);

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(rabbitMQHost);
        return cachingConnectionFactory;
    }
}
