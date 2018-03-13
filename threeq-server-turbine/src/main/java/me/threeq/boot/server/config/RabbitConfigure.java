package me.threeq.boot.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(RabbitConfigure.class);
    @Value("${app.rabbitmq.host:localhost}")
    String rabbitMQHost;

    @Bean
    public ConnectionFactory connectionFactory() {
        LOG.info("Creating RabbitMQHost ConnectionFactory for host: {}", rabbitMQHost);

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(rabbitMQHost);
        return cachingConnectionFactory;
    }
}
