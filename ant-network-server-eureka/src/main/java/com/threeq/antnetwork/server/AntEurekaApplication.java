package com.threeq.antnetwork.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableEurekaServer
public class AntEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntEurekaApplication.class);
    }
}
